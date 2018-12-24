set define off
spool 2_�豸��·����������ű�.log

--ɾ����··�ڹ�ϵ��[T_SYS_ROAD_CROSS]
DROP TABLE T_SYS_ROAD_CROSS;

--�޸�·�ڱ�[T_SYS_CROSS]
--�����ֶ� ��·ID��
alter table T_SYS_CROSS add ROAD_ID varchar2(32) ;
comment on column T_SYS_CROSS.ROAD_ID is '������·ID';

--�������FK_CROSS_ROAD����·ID��Ϊ����У�ָ���·��Ϣ��[T_SYS_ROAD]����;
alter table T_SYS_CROSS add constraint FK_CROSS_ROAD foreign key (ROAD_ID)
  references T_SYS_ROAD(ROAD_ID) on delete cascade;

--ɾ���� ·���ཻ��·[CROSS_ROAD_ID] ·����������·[MAIN_ROAD_ID]
alter table T_SYS_CROSS drop column cross_road_id;
alter table T_SYS_CROSS drop column main_road_id;

--��·�� ���ӵ�·������
alter table T_SYS_ROAD add road_alias_name VARCHAR2(128);
comment on column T_SYS_ROAD.road_alias_name is '��·����';

--�޸�·�α�
--ȡ��·�δ����ΨһԼ��   20160315���� ��ܷ����ֳ�����
alter table T_SYS_ROAD_SECTION
  drop constraint ROAD_SECTION_CODE_UNIQUE cascade;


--�޸ĵ�·�������ñ�[T_SYS_REGION]
--�޸ı���
comment on table T_SYS_REGION is '�����������ñ�';

--ɾ���� �Ƿ�֧���������[HAS_SUPPORT_SPEED] �Ƿ�֧�������������[HAS_SUPPORT_VEHICLE_FLOW]  
--����������ֵ[LIMIT_LARGE_MARGIN]   С����������ֵ[LIMIT_SMALL_MARGIN]  �����ɱ������Ʊ���б�[RELATED_VARIABLE_SPEED]  �������޸���[LIMIT_LOWER];
alter table T_SYS_REGION drop column has_support_speed;
alter table T_SYS_REGION drop column has_support_vehicle_flow;
alter table T_SYS_REGION drop column limit_large_margin;
alter table T_SYS_REGION drop column limit_small_margin;
alter table T_SYS_REGION drop column related_variable_speed;
alter table T_SYS_REGION drop column limit_others;
alter table T_SYS_REGION modify org_privilege_code VARCHAR2(8);
--��� ��� 20160317
alter table T_SYS_REGION modify lane_num null;

--��λ�������ͳ������ٱ������豸��άģ�飻


--�޸ĵ�λ��Ϣ��[T_SYS_SITE]
--���ӵ�λ�����ֶ�
alter table T_SYS_SITE add site_alias_name VARCHAR2(128);
comment on column T_SYS_SITE.site_alias_name is '��λ����';

--���ӹ������ֶ�
alter table T_SYS_SITE add kilomileage number;
comment on column T_SYS_SITE.kilomileage is '������';


--�޸�ִ��·�ڱ������ļ�����������λָ���·�ڱ��¼��ɾ��ʱ����λ��������·��ID�趨Ϊ�գ�
alter table T_SYS_SITE drop constraint FK_T_SYS_SI_REFERENCE_T_SYS_CR;
alter table T_SYS_SITE add constraint FK_T_SYS_SI_REFERENCE_T_SYS_CR foreign key (CROSS_ID) references T_SYS_CROSS (CROSS_ID) on delete set null;

--�޸�ָ��·�α������ļ�����������λָ���·�α��¼��ɾ��ʱ����λ��������·��ID�趨Ϊ�գ�

alter table T_SYS_SITE drop constraint FK_T_SYS_SI_REFERENCE_T_SYS_RO;
alter table T_SYS_SITE add constraint FK_T_SYS_SI_REFERENCE_T_SYS_RO foreign key (ROAD_SECTION_ID) references T_SYS_ROAD_SECTION (ROAD_SECTION_ID) on delete set null;

--����ָ���·������
alter table T_SYS_SITE add constraint FK_T_SITE_ROAD foreign key (ROAD_ID) references t_sys_road (ROAD_ID) on delete set null;

--�޸ĵ��Ӽ��ϵͳ��[T_DEVICE_SYS]
--���� ������ϵ�ṹ ��
alter table T_DEVICE_SYS add architecture char(1) default 1 not null;
comment on column T_DEVICE_SYS.architecture is '������ϵ�ṹ   1 ����ʽ�� 2 �ֲ�ʽ��';

--���ӵ��豸�н��̱�����Լ��
alter table T_DEVICE_SYS add constraint FK_DEVSYS_CONTRACTOR foreign key (CONTRACTOR_ID) references t_device_contractor (CONTRACTOR_ID) on delete set null;

--ɾ���� Ψһֵ[DEVICE_KEY] ������������ID[SERVER_GROUP_TYPE_ID] ��·ID[ROAD_ID] �豸״̬��ʼʱ��[START_TIME] �豸״̬����ʱ��[END_TIME]
alter table T_DEVICE_SYS drop column server_group_type_id;
alter table T_DEVICE_SYS drop column road_id;
alter table T_DEVICE_SYS drop column device_key;
alter table T_DEVICE_SYS drop column start_time;
alter table T_DEVICE_SYS drop column end_time;

--������
alter table T_DEVICE_SYS add server_plat_id VARCHAR2(32);

--�޸�ϵͳ�����[T_DEVICE_SYS_COMPONENT]
--ɾ���� ��س���ID[DRIVE_LANE_ID]
alter table T_DEVICE_SYS_COMPONENT drop column drive_lane_id;

--�޸ĳ����������Ϊ��������б�
comment on column T_DEVICE_SYS_COMPONENT.lane_nbr is '��������б�';

--�޸��豸�������Ϊ������
comment on column T_DEVICE_SYS_COMPONENT.device_nbr  is '������ �������������õ�ҵ����';

--�޸��������[SYS_COMPONENT_TYPE]��ע��
comment on column T_DEVICE_SYS_COMPONENT.sys_component_type is '�������:	';

--�޸�ϵͳ�����,ȡ��ԭ�������Ͷ���,����:
--438	ϵͳ���������������	1	��Ƶ�ɼ�
--438	ϵͳ���������������	2	ץ�����
--438	ϵͳ���������������	3	����
--438	ϵͳ���������������	4	����
--438	ϵͳ���������������	5	���ݴ���
--438	ϵͳ���������������	6	���紫��
--438	ϵͳ���������������	7	�洢



--�޸�Ψһֵ[DEVICE_KEY]����Ϊ���Ψһ���
comment on column T_DEVICE_SYS_COMPONENT.device_key is '���Ψһ���';

--����Ƿ�֧����Ƶ�ֶ�
alter table T_DEVICE_SYS_COMPONENT add is_video_support CHAR(1);
comment on column T_DEVICE_SYS_COMPONENT.is_video_support is '�Ƿ�֧����Ƶ  1 ֧�� 0 ��֧��';

--�����Ƶƽ̨���������[CAMERA_SN]

alter table T_DEVICE_SYS_COMPONENT add camera_sn VARCHAR2(32);
comment on column T_DEVICE_SYS_COMPONENT.camera_sn is '��Ƶƽ̨������� ֧����Ƶ������������Ƶƽ̨�еı��';

--��ӽ��뷽ʽ��[ACCESS_MODE]
alter table T_DEVICE_SYS_COMPONENT add access_mode CHAR(1);
comment on column T_DEVICE_SYS_COMPONENT.access_mode  is '���뷽ʽ ���ػ�����;�ն˺н���:�ն˺л�������ݽ��д���(��ı��豸���)����ת������������ͼƬ��ͼƬ�ϵ��ӱ����Ϊ��������õı��;�ն˺�ת��:ֱ��ת��;��ط�����ֱ�ӽ���;';

--������Ƶ���뷽ʽ��[VIDEO_ACCESS_MODE]
alter table T_DEVICE_SYS_COMPONENT add video_access_mode CHAR(1);
comment on column T_DEVICE_SYS_COMPONENT.video_access_mode is '��Ƶ���뷽ʽ  �����ϵͳ��������:485';
alter table T_DEVICE_SYS_COMPONENT add preview_param VARCHAR2(2048);
alter table T_DEVICE_SYS_COMPONENT add playback_param VARCHAR2(2048);
comment on column T_DEVICE_SYS_COMPONENT.preview_param is '��ƵԤ����������Ҫ���ں�����Ƶ';
comment on column T_DEVICE_SYS_COMPONENT.playback_param is '��Ƶ�طŲ�������Ҫ���ں�����Ƶ';

--ɾ������ �豸��� ΨһԼ��
alter table T_DEVICE_SYS_COMPONENT drop unique(DEVICE_NBR);
--�������� ���Լ�� ����  RELATIONSHIP_1=>FK_COMPONENT_DEVICESYS
alter table T_DEVICE_SYS_COMPONENT drop constraint RELATIONSHIP_1;
alter table T_DEVICE_SYS_COMPONENT add constraint FK_COMPONENT_DEVICESYS foreign key (DEVICE_ID) references T_DEVICE_SYS (DEVICE_ID) on delete cascade;


--�޸Ŀ���ϵͳ������[T_DEVICE_TOLLGATE_SYS]
--����Ƿ�֧��Υ��ȡ֤��
alter table T_DEVICE_TOLLGATE_SYS add is_vio_support CHAR(1);
comment on column T_DEVICE_TOLLGATE_SYS.is_vio_support is '�Ƿ�֧��Υ��ȡ֤  1 ֧�� 0 ��֧��';

--����ۺ�ƽ̨�豸�ǼǱ����
alter table T_DEVICE_TOLLGATE_SYS add integrate_platform_nbr VARCHAR2(32); 
comment on column T_DEVICE_TOLLGATE_SYS.integrate_platform_nbr is '�ۺ�ƽ̨�豸�ǼǱ��';

--�޸���Ƶ���ϵͳ������[T_DEVICE_VIDEO]
--�޸�������뷽ʽ����Ϊ��Ƶ���뷽ʽ
alter table T_DEVICE_VIDEO add video_access_mode CHAR(1);
comment on column T_DEVICE_VIDEO.video_access_mode is '��Ƶ���뷽ʽ  �����ϵͳ��������:485';
alter table T_DEVICE_VIDEO rename column camera_param to CAMERA_SN;
alter table T_DEVICE_VIDEO modify camera_sn VARCHAR2(32);
comment on column T_DEVICE_VIDEO.camera_sn
  is '��Ƶƽ̨������� ֧����Ƶ������������Ƶƽ̨�еı��';
  

--�޸�������ϵͳ����[T_DEVICE_METEOROLOGIC]
--����Ƿ�֧������ɼ���

alter table T_DEVICE_METEOROLOGIC add is_weather_support CHAR(1);
comment on column T_DEVICE_METEOROLOGIC.is_weather_support is '�Ƿ�֧������ɼ�     1 ֧�֣� 0 ��֧��';

--����Ƿ�֧���ܼ�����
alter table T_DEVICE_METEOROLOGIC add is_visibility_support CHAR(1);
comment on column T_DEVICE_METEOROLOGIC.is_visibility_support is '�Ƿ�֧���ܼ���    1 ֧�֣� 0 ��֧��';

--����Ƿ�֧��·����
alter table T_DEVICE_METEOROLOGIC add is_roadsensor_support CHAR(1);
comment on column T_DEVICE_METEOROLOGIC.is_roadsensor_support is '�Ƿ�֧��·��    1 ֧�֣� 0 ��֧��';

--��ӹ����ɱ������Ʊ���б�
alter table T_DEVICE_METEOROLOGIC add related_variable_speed VARCHAR2(256);
comment on column T_DEVICE_METEOROLOGIC.related_variable_speed is '�����ɱ������Ʊ���б�';

--�޸�Υ��ȡ֤ϵͳ��[T_DEVICE_VIO_DEVICE]
--����Ƿ�֧�ֿ��ڹ�����
alter table T_DEVICE_VIO_DEVICE add is_tollgate_support CHAR(1);
comment on column T_DEVICE_VIO_DEVICE.is_tollgate_support is '�Ƿ�֧�ֿ��ڹ��� 1 ֧�� ��0  ��֧��';

--����Ƿ�֧�ֻ��鲼��ϵͳ�ϴ��� 
alter table T_DEVICE_VIO_DEVICE add is_connect_track_sys CHAR(1); 
comment on column T_DEVICE_VIO_DEVICE.is_connect_track_sys is '�Ƿ�֧�ֻ��鲼��ϵͳ �ϴ���֧�ֿ��ڹ���ʱ�������������壻1 ֧�� ��0  ��֧��';


--��ӻ��鲼��ϵͳ������������ֵ��� 
alter table T_DEVICE_VIO_DEVICE add track_sys_nbr_map VARCHAR2(256);
comment on column T_DEVICE_VIO_DEVICE.track_sys_nbr_map is '���鲼��ϵͳ������������ֵ� ��Υ��ȡ֤ϵͳ֧�ֹ���������ݲ���Ҫ�ϴ����鲼��ϵͳʱ,��֧�ֻ��鲼��ϵͳ�ϴ�ʱ,�����ñ�����,��ʱ��Ӧ�ĵ��Ӽ��ϵͳ����Ϊ�羯,���ڵ羯ϵͳ�ڻ��鲼��ϵͳ����ʱ���������Ƽ�����·������羯ϵͳ��ʮ��·��ʱ���Ƽ�����Ϊ����ϵͳ����ÿ��·�����������ϵļ���豸�����۶��٣����ڻ��鲼��ϵͳ�б���Ϊһ��ϵͳ��һ��·��Ӧһ��������ţ���˱��ֶδ洢�羯ϵͳ����·�ڵ�λ�漰�ĵ�·���뼰������ţ����ݸ�ʽΪ����·1����1:�������1;��·2����:�������2;...... ע:��֧�ֿ��ڹ���ʱ����֧�ֻ��鲼��ϵͳ�ϴ�ʱ�������������壻';

--�޸�����ϵͳ���ñ�[T_DEVICE_REGION]
--ɾ���������޸���[LIMIT_OTHERS]��
alter table T_DEVICE_REGION drop column limit_others;

--ɾ���������������[T_DEVICE_SERVER_TYPE_GROUP]
DROP TABLE T_DEVICE_SERVER_TYPE_GROUP;
--ɾ������������������������͹�ϵ���[T_DEVICE_ASSO_GROUP]
DROP TABLE T_DEVICE_ASSO_GROUP;
--ɾ�����ϵͳ����������͹�ϵ��[T_DEVICE_ASSO_SERVER_TYPE]
DROP TABLE T_DEVICE_ASSO_SERVER_TYPE;
--ɾ�����������ͱ�[T_DEVICE_SERVER_TYPE]
DROP TABLE T_DEVICE_SERVER_TYPE;

--���������������[T_DEVICE_SERVER_APPLICATION]
CREATE TABLE T_DEVICE_SERVER_APPLICATION 
(
   SERVER_APP_ID        VARCHAR2(32)         NOT NULL,
   SERVER_ID            VARCHAR2(32),
   APP_TYPE             VARCHAR(32)          NOT NULL,
   SERVER_PORT          VARCHAR2(128),
   CONTEX               VARCHAR2(128),
   SUFFIX               VARCHAR2(8),
   REMARK               VARCHAR2(32),
   CONSTRAINT PK_T_DEVICE_SERVER_APPLICATION PRIMARY KEY (SERVER_APP_ID)
);

COMMENT ON TABLE T_DEVICE_SERVER_APPLICATION IS
'��ŷ�������;��Ϣ����ͨ�ŷ�����ý�����ͼ��洢����ȡ�';
      
alter table T_DEVICE_SERVER_APPLICATION
  add constraint FK_SERVERAPP_SERVER foreign key (SERVER_ID)
  references T_DEVICE_SERVER (SERVER_ID) on delete cascade;

--��������ƽ̨��[T_SERVER_ACCESS_PLAT]
CREATE TABLE T_DEVICE_SERVER_PLAT
(
   SERVER_PLAT_ID       VARCHAR2(32)         NOT NULL,
   SERVER_PLAT_NAME     VARCHAR2(128)        NOT NULL,
--   SERVER_PLAT_TYPE     VARCHAR2(16)         NOT NULL,
   REMARK               VARCHAR2(256),
   SURVEY_SYSTEM_ID     VARCHAR2(32),
   CONSTRAINT PK_T_SERVER_ACCESS_PLAT PRIMARY KEY (SERVER_PLAT_ID)
);

alter table T_DEVICE_SERVER_PLAT
  add constraint FK_T_SERVER_PLAT_TO_SURVEY_SYS foreign key (SURVEY_SYSTEM_ID)
  references t_device_survey_sys (SURVEY_SYSTEM_ID) on delete cascade;
  
COMMENT ON TABLE T_DEVICE_SERVER_PLAT IS '����ƽ̨';


alter table T_DEVICE_SYS
  add constraint FK_DEVSYS_PLAT foreign key (SERVER_PLAT_ID)
  references t_device_server_plat (SERVER_PLAT_ID) on delete set null;

--��������ƽ̨������������ϵ��[T_SERVER_PLAT_ASSO_APPLICATION]
CREATE TABLE T_DEVICE_SERVER_APP_SSO_PLAT
(
   SERVER_APP_ID        VARCHAR2(32),
   SERVER_PLAT_ID       VARCHAR2(32)
);

alter table T_DEVICE_SERVER_APP_SSO_PLAT
  add constraint FK_PLATSSOAPP_TO_APP foreign key (SERVER_APP_ID)
  references T_DEVICE_SERVER_APPLICATION (SERVER_APP_ID) on delete cascade;
  
alter table T_DEVICE_SERVER_APP_SSO_PLAT
  add constraint FK_PLATSSOAPP_TO_PLAT foreign key (SERVER_PLAT_ID)
  references T_DEVICE_SERVER_PLAT (SERVER_PLAT_ID) on delete cascade;
 

--�������Ӽ��ϵͳ�����ƽ̨��ϵ��[T_DEVICE_ASSO_SERVER_PLAT]
--CREATE TABLE T_DEVICE_ASSO_SERVER_PLAT 
--(
--   DEVICE_ID            VARCHAR2(32),
--   SERVER_PLAT_ID       VARCHAR2(32)
--);

--COMMENT ON TABLE T_DEVICE_ASSO_SERVER_PLAT IS '���ϵͳ�����ƽ̨���͹�ϵ��';

--ALTER TABLE T_DEVICE_ASSO_SERVER_PLAT
--   ADD CONSTRAINT FK_SYSSSOPLAT_TO_PLAT FOREIGN KEY (SERVER_PLAT_ID)
--      REFERENCES T_DEVICE_SERVER_PLAT (SERVER_PLAT_ID) on delete cascade;

--ALTER TABLE T_DEVICE_ASSO_SERVER_PLAT
--   ADD CONSTRAINT FK_SYSSSOPLAT_TO_SYS FOREIGN KEY (DEVICE_ID)
--      REFERENCES T_DEVICE_SYS (DEVICE_ID) on delete cascade;


-- Add/modify columns 
-- Create/Recreate primary, unique and foreign key constraints 


spool off

exit;