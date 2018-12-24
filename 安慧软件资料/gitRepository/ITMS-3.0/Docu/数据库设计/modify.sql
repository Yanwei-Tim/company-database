--2015/11/11 ����
--�޸ľ�Ա���ֶ�EVENT_LECEL->EVENT_LEVEL
alter table ITMS3.T_SYS_POLICE rename column EVENT_LECEL to EVENT_LEVEL;

alter table ITMS3.T_SYS_POLICE_POST modify MANAGE_ORG  not null;

alter table ITMS3.T_VIO_ASSO_USER_DEVICE rename column DEVICE_NBR to DEVICE_SYS_NBR;

alter table ITMS3.T_SYS_LANE rename column SITE_ID to SECTION_ID;
alter table ITMS3.T_SYS_LANE drop (DIRECTION_TYPE,DIRECTION_NAME);
alter table ITMS3.T_SYS_LANE drop (ROAD_BRANCH_ID);

create table T_SYS_FESTIVAL 
(
   FESTIVAL_ID          VARCHAR2(32)         not null,
   FESTIVAL_TYPE        VARCHAR2(2)          not null,
   START_DATE           DATE                 not null,
   END_DATE             DATE,
   YEAR                 DATE,
   REMARK               VARCHAR2(128),
   constraint PK_T_SYS_FESTIVAL primary key (FESTIVAL_ID)
);

comment on table T_SYS_FESTIVAL is
'�ڼ�����Ϣ��';

comment on column T_SYS_FESTIVAL.FESTIVAL_TYPE is
'1 Ԫ��
2 ����
3 ������
4 �Ͷ���
5 �����
6 �����
7 �����';

alter table ITMS3.T_VEHTRACK_RESTRICT add FESTIVAL_ID VARCHAR2(32);

alter table ITMS3.T_SYS_ORG drop (ORG_SIGNATURE);
alter table ITMS3.T_SYS_ORG add ORG_SIGNATURE  VARCHAR2(32);
alter table ITMS3.T_SYS_ORG drop (SIGNATURE_NOTIFIER);
alter table ITMS3.T_SYS_ORG add SIGNATURE_NOTIFIER  VARCHAR2(32);

--2015/11/14 ���
--�޸Ķ����ֶΣ�ɾ��ROAD_BRANCH_ID
alter table ITMS3.T_SYS_SECTION drop (ROAD_BRANCH_ID);

--2015/11/16 ���
--�޸�ϵͳ���ܱ����ݣ�֧������ɼ�->1010��֧���̵�ץ��ģʽ->1011,���������ɼ�����
update t_device_sys_function  set function_code='1010' where function_code='2001';
update t_device_sys_function  set function_code='1011' where function_code='2002';
insert into t_device_sys_function (DEVICE_SYS_FUNCTION_ID,FUNCTION_NAME,FUNCTION_CODE,FUNCTION_DESC) values ('1000','�����ɼ�',��1012��,��֧�������ɼ���);

--2015/11/17 ���
--Υ�����������ӹ������Ȩ�޴����ֶ�
alter table T_VIO_VIOLATION add ORG_AUTHORITY_CODE VARCHAR2(32);

--2015/11/18 ���
--ϵͳ�����ͨ��״̬���ӡ���״̬��
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('501', '0', '��״̬', '1', '1', null, null);
--t_vio_asso_action���·�����ֶγ��ȸ�Ϊ32λ
alter table t_vio_asso_action modify ROAD_TYPE varchar2(32);--����ϵͳ����������ϵͳ��š�������LED���ֶ�
delete from T_DEVICE_REGION;
alter table T_DEVICE_REGION add INTEGRATE_PLATFORM_NBR VARCHAR2(32) not null;
alter table T_DEVICE_REGION add RELATED_LED_ID VARCHAR2(256) ;
--ɾ����Դ���ͱ�
drop table T_SYS_RESOURCE_TYPE;
--�½������ļ���
create table T_SYS_EXPORT 
(
   "task_id"            VARCHAR2(32)         not null,
   "func_key"           VARCHAR2(32)         not null,
   "file_name"          VARCHAR2(128)        not null,
   "export_sql"         VARCHAR2(4000)       not null,
   "export_sql2"        VARCHAR2(4000),
   "status"             CHAR(1)              not null,
   "update_time"        DATE                 not null,
   "login_name"         VARCHAR2(32)         not null,
   "file_url"           VARCHAR2(128),
   "remark"             VARCHAR2(128),
   constraint PK_T_SYS_EXPORT primary key ("task_id")
);

comment on table T_SYS_EXPORT is
'��ŵ������ļ���';

comment on column T_SYS_EXPORT."task_id" is
'�����ļ���ID';

comment on column T_SYS_EXPORT."func_key" is
'��Ӧ����Ψһ��';

comment on column T_SYS_EXPORT."file_name" is
'�����ļ�����';

comment on column T_SYS_EXPORT."export_sql" is
'�����ļ�sql';

comment on column T_SYS_EXPORT."export_sql2" is
'�����ļ�����SQL�����SQL���������и���������ֶμ��Ͽ���ʱ�����ǡ�';

comment on column T_SYS_EXPORT."status" is
'����״̬
1 ����
2 �Ŷ���
3 ���ڵ��� 
4  �����';

comment on column T_SYS_EXPORT."update_time" is
'����ʱ��';

comment on column T_SYS_EXPORT."login_name" is
'������';

comment on column T_SYS_EXPORT."file_url" is
'�ļ�·��';

comment on column T_SYS_EXPORT."remark" is
'��ע';

--ɾ���豸���õĵ�λ���ڵ�λ������豸
delete from t_device_sys where t_device_sys.site_id not in 
   ( select distinct t_sys_site.site_id from t_sys_site);
--ɾ���豸������������
delete from t_device_sys
--code�������������11��������ͼƬ�洢������
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('436', '11', '������ͼƬ�洢������', '1', '1', null, null);
--code��a����̨���Ʒ�����->10����̨���Ʒ�����
update T_SYS_CODE  set code_no='10' where code_no='a' and code_type='436';
--��������ӽ����Ǳ���ֶ�
alter table T_SYS_SECTION add ENTER_OR_EXIT_CITY CHAR(1);

--2015/11/19 ���
--�޸�code������Ǳ�ǵ�ֵ
delete from T_SYS_CODE where code_type='410' and code_no='2';
update T_SYS_CODE set code_no='2' where code_type='410' and code_no='3';

--code_type���code�����ӵ���״̬
insert into t_sys_code_type (CODE_TYPE, CODE_TYPE_NAME, ENGLISH_NAME,EDITABLE, REGEX, ENABLE_FLAG)
values ('163', '����״̬','status', '1', null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '163', '1', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '163', '2', '�Ŷ���', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '163', '3', '���ڵ���', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '163', '4', '�����', '1', '1', null, null);

--code��������ȥ�����ǡ�����ֵ
delete from T_SYS_CODE where code_type='070' and code_no='20';
delete from T_SYS_CODE where code_type='070' and code_no='21';

--ʱ�䴦���޸Ĵ����ˡ�����ʱ�䡢�����˵绰�ֶ�����
alter table ITMS3.T_TRAFFIC_EVENT_PROCESS rename column CONFIRM_PERSON to DEAL_PERSON;
alter table ITMS3.T_TRAFFIC_EVENT_PROCESS rename column CONFIRM_TIME to DEAL_TIME;
alter table ITMS3.T_TRAFFIC_EVENT_PROCESS rename column CONFIRM_PERSON_PHONE to DEAL_PERSON_PHONE;

--�����·��������
delete from t_sys_road

--�޸ĵ�·��������
insert into t_sys_code_type (CODE_TYPE, CODE_TYPE_NAME, ENGLISH_NAME,EDITABLE, REGEX, ENABLE_FLAG)
values ('071', '�������ͣ����У�','DIRECTION_TYPE_CITY', '1', null, '1'); 
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '1', '�ɶ�����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '2', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '3', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '4', '�ɱ�����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '5', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '6', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '7', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '071', '8', '����', '1', '1', null, null);
delete from t_sys_code where code_type='070' and code_no='3';
delete from t_sys_code where code_type='070' and code_no='4';
delete from t_sys_code where code_type='070' and code_no='5';
delete from t_sys_code where code_type='070' and code_no='6';
delete from t_sys_code where code_type='070' and code_no='7';
delete from t_sys_code where code_type='070' and code_no='8';
delete from t_sys_code where code_type='070' and code_no='9';
delete from t_sys_code where code_type='070' and code_no='10';

--2015/11/20  ���
--����������Ϣ��
CREATE TABLE T_VEHTRACK_RESTRICT 
(
   RESTRICT_INFO_ID     VARCHAR2(32)         NOT NULL,
   ROAD_ID              VARCHAR2(5),
   TOLLGATE_ID_LIST     VARCHAR2(256),
   RESTRICT_VEHICLE_TYPE CHAR(2),
   RESTRICT_OUTSIDE_VEHICLE CHAR(1),
   RESTRICT_TIME_PERIOD VARCHAR2(64),
   RESTRICT_DIRECTION   CHAR(1),
   RESTRICT_PLATE_NBR   CHAR(1),
   RESTRICT_LAST_PLATE_NBR VARCHAR2(32),
   FESTIVAL_ID          VARCHAR2(32),
   MANAGE_ORG           VARCHAR2(32),
   VALID_START_DATE     DATE,
   VALID_END_DATE       DATE,
   CONSTRAINT PK_T_VEHTRACK_RESTRICT PRIMARY KEY (RESTRICT_INFO_ID)
);

COMMENT ON TABLE T_VEHTRACK_RESTRICT IS
'���յ�·�����͡������ء�ʱ�ε��������С�';

COMMENT ON COLUMN T_VEHTRACK_RESTRICT.ROAD_ID IS
'��·����';

COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_VEHICLE_TYPE IS
'H1���������H2�����ͻ�����';

COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_OUTSIDE_VEHICLE IS
'0���������أ�1�������г���2������ʡ����';

COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_TIME_PERIOD IS
'���ʱ����ϡ����磺6.5��9��16.5��20��ʾ����6�����9�㣬����4���������8�㡣';

COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_DIRECTION IS
'0�����ַ���
1�����У�
2�����У�
3���ɶ�����
4��������
5��������
6���ɱ�����
7������
8������
9������
10������
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_PLATE_NBR IS
'1 ���Ž���
2 ˫�Ž���';

--�������������˹���¼��
CREATE TABLE T_TRAFFIC_MANUAL_WEATHER 
(
   BAD_WEATHER_ID       VARCHAR2(32)         NOT NULL,
   METEOROLOGY_TYPE     CHAR(1),
   ROAD_ID              VARCHAR2(32),
   ROAD_SECTION_ID      VARCHAR2(32),
   DIRECTION_TYPE       CHAR(1),
   DIRECTION_NAME       VARCHAR2(32),
   LON_LAT              VARCHAR2(256),
   EVENT_DESC           VARCHAR2(128),
   REPORT_BY            VARCHAR2(32),
   REPORT_TIME          DATE,
   EVENT_RELEASE_TYPE   CHAR(1),
   ORG_CODE             VARCHAR2(18)         NOT NULL,
   ORG_PRIVILEGE_CODE   VARCHAR2(8)          NOT NULL,
   REMARK               VARCHAR2(256),
   CONSTRAINT PK_T_TRAFFIC_MANUAL_WEATHER PRIMARY KEY (BAD_WEATHER_ID)
);

COMMENT ON TABLE T_TRAFFIC_MANUAL_WEATHER IS
'�˹���¼��������';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_WEATHER.METEOROLOGY_TYPE IS
'1 �ܼ���Ԥ��
2 ·���¶�Ԥ��
3 ·���ˮԤ��
4 ����Ԥ��
5 ·����Ԥ��';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_WEATHER.REPORT_BY IS
'�˹��ϱ�Ԥ����Ϣʱ����д���ֶΡ�';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_WEATHER.EVENT_RELEASE_TYPE IS
'0 δ���
1 �ѽ��';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_WEATHER.ORG_PRIVILEGE_CODE IS
'����Ȩ�޹��˴�����������������ʡ�ܶӱ�����2λ��ʾ��34���ܶ������֧����4λ�����ʾ��3401�������6λ�����ʾ��340101���ж���8λ�����ʾ��34010101��
֧�ӡ���ӡ��жӰ�������֧�ӡ���ӵȻ����������ϵͳ�Զ����ɡ�';

--������·�¼��˹���¼��
CREATE TABLE T_TRAFFIC_MANUAL_EVENT 
(
   ROAD_EVENT_ID        VARCHAR2(32)         NOT NULL,
   EVENT_TYPE           CHAR(2),
   ROAD_ID              VARCHAR2(32),
   ROAD_SECTION_ID      VARCHAR2(32),
   DIRECTION_TYPE       CHAR(1),
   DIRECTION_NAME       VARCHAR2(32),
   LON_LAT              VARCHAR2(256),
   EVENT_DESC           VARCHAR2(128),
   REPORT_BY            VARCHAR2(32),
   REPORT_TIME          DATE,
   EVENT_RELEASE_TYPE   CHAR(1),
   ORG_CODE             VARCHAR2(18)         NOT NULL,
   ORG_PRIVILEGE_CODE   VARCHAR2(8)          NOT NULL,
   REMARK               VARCHAR2(256),
   CONSTRAINT PK_T_TRAFFIC_MANUAL_EVENT PRIMARY KEY (ROAD_EVENT_ID)
);

COMMENT ON TABLE T_TRAFFIC_MANUAL_EVENT IS
'�˹���¼��·�Ϸ�����ӵ�¡��¹ʵ��¼�';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_EVENT.EVENT_TYPE IS
'0  ������
1  ӵ��
2 ͣ��
3 Υͣ
4 ����
5 ����
6 �������������Ƭ
7 ����
';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_EVENT.REPORT_BY IS
'�˹��ϱ�Ԥ����Ϣʱ����д���ֶΡ�';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_EVENT.EVENT_RELEASE_TYPE IS
'0 δ���
1 �ѽ��';

COMMENT ON COLUMN T_TRAFFIC_MANUAL_EVENT.ORG_PRIVILEGE_CODE IS
'����Ȩ�޹��˴�����������������ʡ�ܶӱ�����2λ��ʾ��34���ܶ������֧����4λ�����ʾ��3401�������6λ�����ʾ��340101���ж���8λ�����ʾ��34010101��
֧�ӡ���ӡ��жӰ�������֧�ӡ���ӵȻ����������ϵͳ�Զ����ɡ�';

--MAP_CHISHUI_GAOSU������road_code,����ID�ֶ�
alter table MAP_CHISHUI_GAOSU add road_code VARCHAR2(6);
alter table MAP_CHISHUI_GAOSU add REGIONAL_ID VARCHAR2(32);

--2015/11/23  ���
--�����ţ��豸��ţ�����Ψһ��Լ��
alter table T_DEVICE_SYS_COMPONENT add unique (DEVICE_NBR);

--�޸�����ϵͳ������ֵ�ֶ�����
alter table T_DEVICE_REGION modify LIMIT_OTHERS NUMBER(3);
alter table T_DEVICE_REGION modify LIMIT_LARGE_MARGIN NUMBER(3);
alter table T_DEVICE_REGION modify LIMIT_SMALL_MARGIN NUMBER(3);

--�޸ĵ�·�������������ֶοɿ�
alter table T_SYS_REGION modify DISTANCE NUMBER(10) null ;

--�޸��豸����/������ɾ�����Ͻ����ʶ�����Ͻ��ʱ��->����ʱ��
alter table T_DEVICE_FAULT drop (RESOLVE_FLAG);
alter table T_DEVICE_FAULT rename column RESOLVE_TIME to PROCESS_TIME;

--�޸�code�����ϴ���״̬
delete from t_sys_code where code_type='466';
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('466', '0', 'δ����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('466', '1', '���账��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('466', '2', 'δ���', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('466', '3', '�ѽ��', '1', '1', null, null);

--�޸Ķ�����������Լ�3����ʶ�ֶο�Ϊ��,�������Ʋ���Ϊ��
alter table T_SYS_SECTION modify LANE_NUM null;
alter table T_SYS_SECTION modify HAS_EMERGENCY_LANE null;
alter table T_SYS_SECTION modify HAS_BICYCLE_LANE null;
alter table T_SYS_SECTION modify HAS_PAVEMENT null;
alter table T_SYS_SECTION modify DIRECTION_NAME not null;

--�޸��豸��ɾ��ͣ�ñ�ʶ������ʱ�䡢ͳ�Ƽ춨�ʱ�ʶ��ͳ�������ʱ�ʶ������ʱ��->ʹ��״̬����ʱ��
alter table T_DEVICE_SYS drop (DISABLE_FLAG);
alter table T_DEVICE_SYS drop (USELESS_DATE);
alter table T_DEVICE_SYS drop (STAT_CERT_RATE);
alter table T_DEVICE_SYS drop (STAT_ONLINE_RATE);
alter table T_DEVICE_SYS rename column ENABLE_DATE to ENABLE_UPDATE_DATE;

--�޸�code��ʹ��״̬��1 ���� 2 ͣ�� 3 ����
delete from t_sys_code where code_type='405';
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('405', '0', 'δ����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('405', '1', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('405', '2', 'ͣ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('405', '3', '����', '1', '1', null, null);

--2015/11/24  ��ܣ��������ݿ�ͬ����23�ţ�
--MAP_CHISHUI_GAOSU�����ӵ�·������ơ���·�յ������ֶ�
alter table MAP_CHISHUI_GAOSU add FRoadName VARCHAR2(64);
alter table MAP_CHISHUI_GAOSU add BRoadName VARCHAR2(64);
COMMENT ON COLUMN MAP_CHISHUI_GAOSU.FRoadName IS '�������';
COMMENT ON COLUMN MAP_CHISHUI_GAOSU.BRoadName IS '�յ�����';

--�޸Ľ������б���������������ֶ�
alter table T_VEHTRACK_RESTRICT add RESTRICT_CONBINATION CHAR(1);
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_CONBINATION IS '�����������ֵΪ1-7��Ϊ������������';

COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_INFO_ID IS '������ϢID';
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.TOLLGATE_ID_LIST IS '����ID�б�';
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.RESTRICT_LAST_PLATE_NBR IS '����β����ֹ';
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.FESTIVAL_ID IS '�ڼ�������';
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.MANAGE_ORG IS '������';
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.VALID_START_DATE IS '��Ч��ʼ';
COMMENT ON COLUMN T_VEHTRACK_RESTRICT.VALID_END_DATE IS '��Ч����';

--�޸Ĺ���/������־���������ID�ֶ�
alter table T_DEVICE_FAULT_LOG add SYS_COMPONENT_ID VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_FAULT_LOG.SYS_COMPONENT_ID IS '���ID';
COMMENT ON COLUMN T_DEVICE_FAULT_LOG.DEVICE_ID IS '���Ӽ��ϵͳID';

--�޸��豸����/������
alter table T_DEVICE_FAULT add SYS_COMPONENT_ID VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_FAULT.SYS_COMPONENT_ID IS '���ID';
COMMENT ON COLUMN T_DEVICE_FAULT.DEVICE_ID IS '���Ӽ��ϵͳID';


--2015/11/25  ���
--�豸״̬���ӣ�4 �쳣
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('412', '4', '�쳣', '1', '1', null, null);

--2015/11/26  ���
--�޸�ά�����ǼǱ�
alter table T_DEVICE_MAINTAIN_REGISTER modify CREATE_TIME null;
alter table T_DEVICE_MAINTAIN_REGISTER rename column CREATE_BY to ASSIGN_BY;
alter table T_DEVICE_MAINTAIN_REGISTER rename column CREATE_TIME to ASSIGN_TIME;

--����������ά������ϵ��
CREATE TABLE T_DEVICE_FAULT_MAINTAIN 
(
   FAULT_MAINTENANCE_ID VARCHAR2(32)         NOT NULL,
   MAINTENANCE_ID       VARCHAR2(32)         NOT NULL,
   FAULT_ID             VARCHAR2(32)         NOT NULL,
   CONSTRAINT PK_T_DEVICE_FAULT_MAINTAIN PRIMARY KEY (FAULT_MAINTENANCE_ID)
);

COMMENT ON TABLE T_DEVICE_FAULT_MAINTAIN IS
'������ά������ϵ��';
COMMENT ON COLUMN T_DEVICE_FAULT_MAINTAIN.FAULT_MAINTENANCE_ID IS
'������ά������ϵID';
COMMENT ON COLUMN T_DEVICE_FAULT_MAINTAIN.MAINTENANCE_ID IS
'ά����ID';
COMMENT ON COLUMN T_DEVICE_FAULT_MAINTAIN.FAULT_ID IS
'������ϢID';

ALTER TABLE T_DEVICE_FAULT_MAINTAIN
   ADD CONSTRAINT FK_T_DEVICE_REFERENCE_T_FAULT FOREIGN KEY (FAULT_ID)
      REFERENCES T_DEVICE_FAULT (FAULT_ID);

ALTER TABLE T_DEVICE_FAULT_MAINTAIN
   ADD CONSTRAINT FK_T_DEVICE_MAINTENANCE FOREIGN KEY (MAINTENANCE_ID)
      REFERENCES T_DEVICE_MAINTAIN_REGISTER (MAINTENANCE_ID);

--ɾ������/������ά����ID
alter table T_DEVICE_FAULT drop (MAINTENANCE_ID);


--2015/11/27  ���
--�޸�ά�����ǼǱ��ֶ�����
alter table T_DEVICE_MAINTAIN_REGISTER drop (PHOTO);
alter table T_DEVICE_MAINTAIN_REGISTER add MAINTENANCE_PHOTO VARCHAR2(256);
COMMENT ON COLUMN T_DEVICE_MAINTAIN_REGISTER.MAINTENANCE_PHOTO IS 'ͼƬ';

--���������ӹ������ơ�����ʱ��
alter table T_SYS_EXPORT ADD func_name VARCHAR2(32);
alter table T_SYS_EXPORT ADD create_time DATE;
COMMENT ON COLUMN T_SYS_EXPORT.func_name IS '��������';
COMMENT ON COLUMN T_SYS_EXPORT.create_time IS '����ʱ��';


--2015/11/28  ���
--��·�����ӷ��������ֶ�
alter table T_SYS_ROAD ADD DIRECTION_TYPE VARCHAR2(6);
COMMENT ON COLUMN T_SYS_ROAD.DIRECTION_TYPE is '��������';

--ɾ����·�����з������ơ����з��������ֶ�

--·�α����ӷ��������ֶ�
alter table T_SYS_ROAD_SECTION ADD DIRECTION_TYPE VARCHAR2(6);
COMMENT ON COLUMN T_SYS_ROAD_SECTION.DIRECTION_TYPE is '��������';

--·�α����з������ơ����з������Ƹ�Ϊ������ơ��ص�����

--2015/11/30  ���
--���ϱ��������ӻ���Ȩ�޴����ֶ�
delete from T_DEVICE_FAULT;
alter table T_DEVICE_FAULT add ORG_PRIVILEGE_CODE VARCHAR2(8) not null;
COMMENT ON COLUMN  T_DEVICE_FAULT.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--���ϱ�����־�����ӻ���Ȩ�޴����ֶ�
delete from T_DEVICE_FAULT_LOG;
alter table T_DEVICE_FAULT_LOG add ORG_PRIVILEGE_CODE VARCHAR2(8) not null;
COMMENT ON COLUMN  T_DEVICE_FAULT_LOG.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--ά�����ǼǱ����ӻ���Ȩ�޴����ֶ�
delete from T_DEVICE_MAINTAIN_REGISTER ;
alter table T_DEVICE_MAINTAIN_REGISTER add ORG_PRIVILEGE_CODE VARCHAR2(8) not null;
COMMENT ON COLUMN  T_DEVICE_MAINTAIN_REGISTER.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--�����豸Ȩ�޷����
CREATE TABLE T_DEVICE_SHARE_RIGHTS 
(
   SHARE_ID             VARCHAR2(32)         NOT NULL,
   DEVICE_ID            VARCHAR2(32)         NOT NULL,
   ORG_PRIVILEGE_CODE   VARCHAR2(8)          NOT NULL,
   CONSTRAINT PK_T_DEVICE_SHARE_RIGHTS PRIMARY KEY (SHARE_ID)
);

COMMENT ON TABLE T_DEVICE_SHARE_RIGHTS IS
'�豸Ȩ�޷����';

COMMENT ON COLUMN T_DEVICE_SHARE_RIGHTS.ORG_PRIVILEGE_CODE IS
'����Ȩ�޹��˴�����������������ʡ�ܶӱ�����2λ��ʾ��34���ܶ������֧����4λ�����ʾ��3401�������6λ�����ʾ��340101���ж���8λ�����ʾ��34010101��֧�ӡ���ӡ��жӰ�������֧�ӡ���ӵȻ����������ϵͳ�Զ����ɡ�';

ALTER TABLE T_DEVICE_SHARE_RIGHTS
   ADD CONSTRAINT FK_T_DEVICE_REFERENCE_T_SHARE FOREIGN KEY (DEVICE_ID)
      REFERENCES T_DEVICE_SYS (DEVICE_ID);

--���Ӽ��ϵͳ�����ӵ�·ID�ֶ�
alter table T_DEVICE_SYS add ROAD_ID VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_SYS.ROAD_ID is '��·ID';
alter table T_DEVICE_SYS add ORG_PRIVILEGE_CODE VARCHAR2(8) ;
COMMENT ON COLUMN T_DEVICE_SYS.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���'

--·�α�����·��������ơ�·�ν��������ƣ�ɾ�����з������ơ����з������ơ���������

alter table T_SYS_ROAD_SECTION add ROAD_BEGIN_NAME VARCHAR2(128);
alter table T_SYS_ROAD_SECTION add ROAD_END_NAME VARCHAR2(128);
COMMENT ON COLUMN T_SYS_ROAD_SECTION.ROAD_BEGIN_NAME is'·���������';
COMMENT ON COLUMN T_SYS_ROAD_SECTION. ROAD_END_NAME is'·�ν���������';

alter table T_SYS_ROAD_SECTION drop (UP_DIRECTION);
alter table T_SYS_ROAD_SECTION drop (DOWN_DIRECTION);
alter table T_SYS_ROAD_SECTION drop (DIRECTION_TYPE);

--�ܼ������ݱ��������ݱ�·�����ݱ�ɾ��·��Ԥ���¼�ID
alter table T_TRAFFIC_VISIBILITY drop (ALARM_EVENT_ID);
alter table T_TRAFFIC_WEATHER drop (ALARM_EVENT_ID);
alter table T_TRAFFIC_ROADSENSOR drop (ALARM_EVENT_ID);

--�ܼ������ݱ��������ݱ�·�����ݱ��¼ʱ���Ϊ����Ϊ��
alter table T_TRAFFIC_VISIBILITY modify RECORD_TIME not null;
alter table T_TRAFFIC_WEATHER modify RECORD_TIME not null;
alter table T_TRAFFIC_ROADSENSOR modify RECORD_TIME not null;

--2015/12/1  ���

--Υ��������·�ڴ����ֶ�,��·��/·�δ����Ϊ·�δ��룻
alter table T_VIO_VIOLATION add CROSS_CODE VARCHAR2(12);
alter table T_VIO_VIOLATION rename column JUNCTION_CODE to ROAD_SECTION_CODE;

--������ѲԤ����Ϣ��
create table T_TRAFFIC_PLAN 
(
   VIDEO_PLAN_ID        VARCHAR2(32)         not null,
   ORG_ID               VARCHAR2(32)         not null,
   VIDEO_PLAN_NAME      VARCHAR2(256)        not null,
   ENABLE_FLAG          CHAR(1)              not null,
   CREATE_BY            VARCHAR2(32)         not null,
   CREATE_TIME          DATE                 not null,
   UPDATE_BY            VARCHAR2(32),
   UPDATE_TIME          DATE,
   constraint PK_T_TRAFFIC_PLAN primary key (VIDEO_PLAN_ID)
);

comment on table T_TRAFFIC_PLAN is
'��ѲԤ����Ϣ';

--������Ѳ��־��Ϣ��
create table T_TRAFFIC_PLAN_LOG 
(
   VIDEO_PLAN_LOG_ID    VARCHAR2(32)         not null,
   VIDEO_PLAN_ID        VARCHAR2(32),
   VIDEO_PLAN_NBR       VARCHAR2(32),
   VIDEO_PLAN_START_TIME DATE                 not null,
   VIDEO_PLAN_END_TIME  DATE                 not null,
   VIDEO_PLAN_PERSON    VARCHAR2(32)         not null,
   COMPUTER_IP          VARCHAR2(32),
   constraint PK_T_TRAFFIC_PLAN_LOG primary key (VIDEO_PLAN_LOG_ID)
);

comment on table T_TRAFFIC_PLAN_LOG is
'��¼ÿ����Ѳ����־��Ϣ';

create index "Relationship_2_FK" on T_TRAFFIC_PLAN_LOG (
   VIDEO_PLAN_ID ASC
);


---������Ѳ��Ƶ��־��Ϣ��
create table T_TRAFFIC_VIDEO_LOG 
(
   VIDEO_LOG_ID         VARCHAR2(32)         not null,
   VIDEO_PLAN_LOG_ID    VARCHAR2(32),
   DEVICE_ID            VARCHAR2(32)         not null,
   QUESTION_FIND        VARCHAR2(256),
   RESULT_DESC          VARCHAR2(256),
   VIDEO_PLAN_START_TIME DATE                 not null,
   VIDEO_PLAN_END_TIME  DATE                 not null,
   constraint PK_T_TRAFFIC_VIDEO_LOG primary key (VIDEO_LOG_ID)
);

comment on table T_TRAFFIC_VIDEO_LOG is
'��¼һ����Ѳ�����е�������Ƶ��־��Ϣ��';

create index "Relationship_3_FK" on T_TRAFFIC_VIDEO_LOG (VIDEO_PLAN_LOG_ID ASC);

alter table T_TRAFFIC_VIDEO_LOG
   add constraint FK_T_TRAFFIC_T_VIDEO foreign key (VIDEO_PLAN_LOG_ID)
      references T_TRAFFIC_PLAN_LOG (VIDEO_PLAN_LOG_ID);

--����Ԥ��������Ƶ��Ϣ��
create table T_TRAFFIC_PLAN_VIDEO 
(
   RELATED_VIDEO_ID     VARCHAR2(32)          not null,
   VIDEO_PLAN_ID        VARCHAR2(32),
   DEVICE_ID            VARCHAR2(32)         not null,
   SORT_INDEX           INTEGER              not null,
   PRESET_LIST          VARCHAR2(1024)       not null,
   CRUISE_TIME          INTEGER,
   constraint PK_T_TRAFFIC_PLAN_VIDEO primary key (RELATED_VIDEO_ID)
);

comment on table T_TRAFFIC_PLAN_VIDEO is
'Ԥ��������Ƶ��Ϣ';

comment on column T_TRAFFIC_PLAN_VIDEO.SORT_INDEX is
'��Ƶ�豸��һ��Ԥ���е�����';

comment on column T_TRAFFIC_PLAN_VIDEO.PRESET_LIST is
'�ԡ�|������';

comment on column T_TRAFFIC_PLAN_VIDEO.CRUISE_TIME is
'�Զ�Ԥ��ʱ����Ϊ�գ��˹�Ԥ��ʱΪ�ա�';

create index "Relationship_1_FK" on T_TRAFFIC_PLAN_VIDEO (
   VIDEO_PLAN_ID ASC
);

alter table T_TRAFFIC_PLAN_VIDEO
   add constraint FK_T_TRAFFIC_RELATED_VIDEO foreign key (VIDEO_PLAN_ID)
      references T_TRAFFIC_PLAN (VIDEO_PLAN_ID);

--������ƵԤ��λ��Ϣ��
create table T_TRAFFIC_PRESET 
(
   PRESET_RECORD_ID     VARCHAR2(32)         not null,
   DEVICE_ID            VARCHAR2(32)         not null,
   SYS_COMPONENT_ID     VARCHAR2(32),
   PRESET               INTEGER              not null,
   PRESET_DESC          VARCHAR2(32),
   CREATE_BY            VARCHAR2(32)         not null,
   CREATE_TIME          DATE                 not null,
   UPDATE_BY            VARCHAR2(32),
   UPDATE_TIME          DATE,
   constraint PK_T_TRAFFIC_PRESET primary key (PRESET_RECORD_ID)
);

comment on table T_TRAFFIC_PRESET is
'�洢��Ƶ��Ԥ��λ��Ϣ';

--2015/12/2  ���
--·��Ԥ���¼����������¼�����
delete from t_sys_code where code_type='512' and code_no between 300 and 306;
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '300', 'ӵ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '301', 'ͣ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '302', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '303', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '304', '�������������Ƭ', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '305', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '306', 'ѹ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '307', '����������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '308', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '309', '���', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('512', '310', '��ͷ', '1', '1', null, null);

--�޸��¼�����ֵ������
delete from t_sys_code where code_type='434';
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '0', 'ӵ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '1', 'ͣ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '2', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '3', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '4', '�������������Ƭ', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '5', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '6', 'ѹ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '7', '����������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '8', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '9', '���', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('434', '10', '��ͷ', '1', '1', null, null);

--���Ӽ��ϵͳ�����ӳн���ID�ֶ�
alter table T_DEVICE_SYS add CONTRACTOR_ID VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_SYS.CONTRACTOR_ID is'�н���ID';

--���������ID�ֶθ�Ϊ����Ȩ�޹��˴���
alter table T_FLOW_FIVE_MIN drop (ORG_CODE);
alter table T_FLOW_FIVE_MIN add ORG_PRIVILEGE_CODE VARCHAR2(8) ;
COMMENT ON COLUMN T_FLOW_FIVE_MIN.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--ɾ��code����Ԥ���¼������͵�ֵ
delete from t_sys_code where code_type='512';

--Υ����¼�����ֶγ��ȸ�Ϊ32λ
alter table T_VIO_VIOLATION modify ENTRY_BY VARCHAR2(32);

--��·�����
alter table T_SYS_REGION modify DISTANCE not null;

--2015/12/3  ��ܣ���������µ�12��2�ţ�
--�޸���������ֶ����ͣ�number(10,2)
alter table T_SYS_REGION modify DISTANCE  null;
update T_SYS_REGION  set DISTANCE='';
alter table T_SYS_REGION modify DISTANCE number(10,2);
update T_SYS_REGION  set DISTANCE='0.3';
alter table T_SYS_REGION modify DISTANCE not null;

--����ϵͳ������־���е�����
update T_SYS_OPERATION_LOG set sys_function_code='01020201';

--��·�¼��˹���¼���¼������ֶ����͸�ΪVARCHAR2(2)
alter table T_TRAFFIC_MANUAL_EVENT modify EVENT_TYPE VARCHAR2(2);

--2015/12/4�����Ը��µ�12��3�ţ�
--�޸��������������Ϊ�գ�����û���ã�
alter table T_SYS_REGION modify DISTANCE  null;

--ɾ��ϵͳ����ģ��ϵͳ����˵�
delete from  T_SYS_MENU where menu_code='0505';

--���������Ӵ���ʱ���ֶ�
alter table T_FLOW_FIVE_MIN add CREATE_TIME DATE ; 
COMMENT ON COLUMN T_FLOW_FIVE_MIN.CREATE_TIME IS '����ʱ��';

--���²�����־���е�����
update T_SYS_OPERATION_LOG set ope_user_name='355e8f04ce7447929dde896e289c84ef';

--2015/12/7  ���
--�޸�Σ��Ʒ����ʻ��·������ɾ��GPS��γ���ֶΣ����Ӿ�γ���ֶ�
alter table T_VEHTRACK_DANGER_VEH_REG drop (GPS);
alter table T_VEHTRACK_DANGER_VEH_REG add LON_LAT VARCHAR2(128);
COMMENT ON COLUMN T_VEHTRACK_DANGER_VEH_REG.LON_LAT is '��γ��';

--�޸�����ϵͳ���ñ������ֶ�ֵ������number(10)->number(10,2)
alter table T_DEVICE_REGION modify DISTANCE  null;
update T_DEVICE_REGION  set DISTANCE='';
alter table T_DEVICE_REGION modify DISTANCE NUMBER(10,2);
update T_DEVICE_REGION  set DISTANCE='10';
alter table T_DEVICE_REGION modify DISTANCE not null;

--�޸�·������ֵ����
alter table T_SYS_CROSS modify CROSS_TYPE VARCHAR2(2);
alter table T_SYS_CROSS modify CROSS_LONGITUDE NUMBER(10,6);
alter table T_SYS_CROSS modify CROSS_LATITUDE  NUMBER(10,6);

--��·������Ψһ��Լ������·���
alter table T_SYS_ROAD add constraint ROAD_CODE_UNIQUE unique(ROAD_CODE);

--·�α�����Ψһ��Լ����·�δ���
delete from T_SYS_ROAD_SECTION;
alter table T_SYS_ROAD_SECTION add constraint ROAD_SECTION_CODE_UNIQUE unique(ROAD_SECTION_CODE);

--·�ڱ�����Ψһ��Լ����·�ڱ��
alter table T_SYS_CROSS add constraint CROSS_CODE_UNIQUE unique(CROSS_CODE);

--��λ������Ψһ��Լ������λ����
alter table T_SYS_SITE add constraint SITE_CODE_UNIQUE unique(SITE_CODE);

--���������Ψһ��Լ������λID+��������
--���ұ����ظ���¼
/* select t.*, t.rowid
  from T_SYS_SECTION t
 where ((SELECT COUNT(*)
           FROM T_SYS_SECTION
          where site_id = t.site_id
            and direction_type = t.direction_type) > 1)
 order by site_id, direction_type; */

alter table T_SYS_SECTION add constraint SITE_ID_DIRECTION_TYPE unique(SITE_ID,DIRECTION_TYPE);

--��������Ψһ��Լ��
alter table T_SYS_REGION add constraint REGIONAL_CODE_UNIQUE unique(REGIONAL_CODE);

--�޸Ĺ������ֶ�ֵ������
alter table T_VEHTRACK_PASS modify VEHICLE_SHAPE VARCHAR2(2);

--����ͨ�з�ʽ��050����ֵ
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '0', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '1', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '2', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '3', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '4', '��������ͨ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '5', '��ת', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '6', '��ת', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '7', '��ͷ', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '8', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '9', '����ͨ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '100', '����ͨ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '050', '101', '����', '1', '1', null, null);

--2015/12/8  ���
--�޸ĵ�λ��
delete from t_sys_site where site_id='c587c181691a4674bfd0128cb2ed6046' or site_id='147ba844d7fa4922a9de9ddbf398de38';
alter table t_sys_site modify org_id not null;

--�޸������������벻��Ϊ�գ������Ѿ����ã�
alter table T_SYS_REGION modify DISTANCE not null;

--�޸�·�α�·����ʼ��̡�·�ν�������ֶ�����
update T_SYS_ROAD_SECTION set BEGIN_METER='';
update T_SYS_ROAD_SECTION set END_METER='';
alter table T_SYS_ROAD_SECTION modify BEGIN_METER VARCHAR2(10);
alter table T_SYS_ROAD_SECTION modify END_METER   VARCHAR2(10);

--�޸�����Ԥ���¼�������
update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='';
alter table T_TRAFFIC_ALARM_EVENT modify ALARM_EVENT_TYPE CHAR(3)
alter table T_TRAFFIC_ALARM_EVENT modify SUB_ALARM_EVENT VARCHAR2(2)
update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='506' where  ALARM_EVENT_ID='101011';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='02' where  ALARM_EVENT_ID='101011';

update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='506' where  ALARM_EVENT_ID='101012';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='05' where  ALARM_EVENT_ID='101012';

update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='502' where  ALARM_EVENT_ID='101013';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='2' where  ALARM_EVENT_ID='101013';

update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='502' where  ALARM_EVENT_ID='101014';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='3' where  ALARM_EVENT_ID='101014';

update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='502' where  ALARM_EVENT_ID='101015';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='4' where  ALARM_EVENT_ID='101015';

update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='502' where  ALARM_EVENT_ID='101016';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='5' where  ALARM_EVENT_ID='101016';

update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='434' where  ALARM_EVENT_ID='101017';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='3' where  ALARM_EVENT_ID='101017';

update T_TRAFFIC_ALARM_EVENT set ALARM_EVENT_TYPE='502' where  ALARM_EVENT_ID='101010';
update T_TRAFFIC_ALARM_EVENT set SUB_ALARM_EVENT='1' where  ALARM_EVENT_ID='101010';

--2015/12/9  ���
--�޸�code_type����������->����Ԥ������
update T_SYS_CODE_TYPE set code_type_name='����Ԥ������' where code_type='502';

--�޸��ճ�ά�����ֶ�ע�͡��豸ID->���Ӽ��ϵͳID
COMMENT ON COLUMN T_DEVICE_DAILY_MAINTAIN.DEVICE_ID is '���Ӽ��ϵͳID';

--���ӽڼ�������code_type��codeֵ
insert into t_sys_code_type (CODE_TYPE, CODE_TYPE_NAME, ENGLISH_NAME,EDITABLE, REGEX, ENABLE_FLAG)
values ('020', '�ڼ�������','FESTIVAL_TYPE', '1', null, '1'); 

insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '020', '1', 'Ԫ��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '020', '2', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '020', '3', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '020', '4', '�Ͷ���', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '020', '5', '�����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '020', '6', '�����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '020', '7', '�����', '1', '1', null, null);

--ϵͳ���ܱ����ӷ���ID�ֶ�
alter table T_SYS_FUNCTION  add SERVICE_ID VARCHAR2(32);
COMMENT ON COLUMN  T_SYS_FUNCTION.SERVICE_ID is '����ID';

--�˵����޸ĸ��˵������ֶγ���
alter table T_SYS_MENU modify PARENT_CODE VARCHAR2(32);

--���ӵ�·�����ֶ�
insert into t_sys_code_type (CODE_TYPE, CODE_TYPE_NAME, ENGLISH_NAME,EDITABLE, REGEX, ENABLE_FLAG)
values ('072', '��·����','ROAD_DIRECTION_TYPE', '1', null, '1'); 
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '072', '1', '��������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '072', '2', '�ϱ�����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '072', '3', '����-���Ϸ���', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ( '072', '4', '����-��������', '1', '1', null, null);

--2015/12/10  ���
--����511��·��Ԥ���¼����
update T_SYS_CODE set code_no='506' where code_type='511' and code_no='1';
update T_SYS_CODE set code_no='502' where code_type='511' and code_no='2';
update T_SYS_CODE set code_no='434' where code_type='511' and code_no='3';
update T_SYS_CODE set code_no='500' where code_type='511' and code_no='4';

--�޸����������״̬�ֶ�ֵ����
alter table T_DEVICE_SYS_COMPONENT modify ONLINE_STATUS VARCHAR2(1);

--�޸ĵ�·���·�����ֶ�����
update T_SYS_ROAD set ROAD_LENGTH='';
alter table T_SYS_ROAD modify ROAD_LENGTH number(10,2);

--��������Сʱ������
CREATE TABLE T_TRAFFIC_ONE_HOUR_FLOW 
(
   SECTION_STATE_ID     VARCHAR2(32)         NOT NULL,
   SECTION_ID           VARCHAR2(32)         NOT NULL,
   TOTAL_NUM            NUMBER(6),
   LARGE_NUM            NUMBER(6),
   SMALL_NUM            NUMBER(6),
   OTHER_NUM            NUMBER(6),
   AVR_SPEED            NUMBER(6,2),
   VEH_TAIL_SPACE       NUMBER(6,2),
   UPDATE_TIME          DATE                 NOT NULL,
   ONE_HOUR_FLOW        NUMBER(6),
   ONE_HOUR_AVR_SPEED   NUMBER(6,2),
   ORG_PRIVILEGE_CODE   VARCHAR2(8)          NOT NULL,
   CONSTRAINT PK_T_TRAFFIC_ONE_HOUR_FLOW PRIMARY KEY (SECTION_STATE_ID)
);

COMMENT ON TABLE T_TRAFFIC_ONE_HOUR_FLOW IS
'����һСʱ������';

COMMENT ON COLUMN T_TRAFFIC_ONE_HOUR_FLOW.TOTAL_NUM IS
'�������ܳ���';

COMMENT ON COLUMN T_TRAFFIC_ONE_HOUR_FLOW.LARGE_NUM IS
'����';

COMMENT ON COLUMN T_TRAFFIC_ONE_HOUR_FLOW.SMALL_NUM IS
'С����';

COMMENT ON COLUMN T_TRAFFIC_ONE_HOUR_FLOW.OTHER_NUM IS
'��������';

COMMENT ON COLUMN T_TRAFFIC_ONE_HOUR_FLOW.AVR_SPEED IS
'ƽ������';

COMMENT ON COLUMN T_TRAFFIC_ONE_HOUR_FLOW.VEH_TAIL_SPACE IS
'��ͷʱ��';

COMMENT ON COLUMN T_TRAFFIC_ONE_HOUR_FLOW.ORG_PRIVILEGE_CODE IS
'����Ȩ�޹��˴�����������������ʡ�ܶӱ�����2λ��ʾ��34���ܶ������֧����4λ�����ʾ��3401�������6λ�����ʾ��340101���ж���8λ�����ʾ��34010101��֧�ӡ���ӡ��жӰ�������֧�ӡ���ӵȻ����������ϵͳ�Զ����ɡ�';

--����5����������ɾ��һСʱ��������һСʱƽ������ƽ�������ֶ�
alter table T_TRAFFIC_SECTION_FLOW drop(ONE_HOUR_FLOW);
alter table T_TRAFFIC_SECTION_FLOW drop(ONE_HOUR_AVR_SPEED);

--����1Сʱ������ɾ��һСʱ��������һСʱƽ������ƽ�������ֶ�
alter table T_TRAFFIC_ONE_HOUR_FLOW drop(ONE_HOUR_FLOW);
alter table T_TRAFFIC_ONE_HOUR_FLOW drop(ONE_HOUR_AVR_SPEED);

--���Ӷ���һСʱ��������������ID�������С�
--����sequence
create sequence SEQ_T_FLOW_ONE_HOUR
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
cache 20;

--����trigger
create or replace trigger TRIG_T_FLOW_ONE_HOUR
  before insert on T_TRAFFIC_ONE_HOUR_FLOW
  for each row
begin
  if(:new.SECTION_STATE_ID is null or :new.SECTION_STATE_ID = '') then
  select SEQ_T_FLOW_ONE_HOUR.nextval into :new.SECTION_STATE_ID from dual;
  end if;
end TRIG_T_FLOW_ONE_HOUR;

--�ճ�ά��������ά����Ա����ϵ��ʽ�ֶ�
alter table T_DEVICE_DAILY_MAINTAIN add MAINTAIN_PERSON VARCHAR2(32);
alter table T_DEVICE_DAILY_MAINTAIN add PHONE VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_DAILY_MAINTAIN.MAINTAIN_PERSON is 'ά����Ա';
COMMENT ON COLUMN T_DEVICE_DAILY_MAINTAIN.PHONE is '��ϵ��ʽ';

--�������ģ����ر����ӳ��������ֶ�
--Σ��Ʒ����ʻ��·������T_VEHTRACK_DANGER_VEH_REG���ӳ��������ֶ�
alter table T_VEHTRACK_DANGER_VEH_REG add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_DANGER_VEH_REG.VEHICLE_SHAPE is '��������';
--���������:T_VEHTRACK_REGIONAL_PASS���ӳ��������ֶ�
alter table T_VEHTRACK_REGIONAL_PASS add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_REGIONAL_PASS.VEHICLE_SHAPE is '��������';
--Υ�����ɳ�����:T_VEHTRACK_PASS_TO_VIO���ӳ��������ֶ�
alter table T_VEHTRACK_PASS_TO_VIO add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_PASS_TO_VIO.VEHICLE_SHAPE is '��������';
--���Ƴ�������¼��:T_VEHTRACK_CLONE_VEHICLE���ӳ��������ֶ�
alter table T_VEHTRACK_CLONE_VEHICLE add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_CLONE_VEHICLE.VEHICLE_SHAPE is '��������';
--���Ƴ�������¼��T_VEHTRACK_FAKE_VEHICLE���ӳ��������ֶ�
alter table T_VEHTRACK_FAKE_VEHICLE add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_FAKE_VEHICLE.VEHICLE_SHAPE is '��������';
--����/���Ƴ�����T_VEHTRACK_FAKE_CLONE���ӳ��������ֶ�
alter table T_VEHTRACK_FAKE_CLONE add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_FAKE_CLONE.VEHICLE_SHAPE is '��������';
--���س��ر�T_VEHTRACK_TRACK���ӳ��������ֶ�
alter table T_VEHTRACK_TRACK add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_TRACK.VEHICLE_SHAPE is '��������';
--���η���Ԥ����T_VEHTRACK_SEC_ALARM���ӳ��������ֶ�
alter table T_VEHTRACK_SEC_ALARM add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_SEC_ALARM.VEHICLE_SHAPE is '��������';
--���ر�����T_VEHTRACK_ALARM���ӳ��������ֶ�
alter table T_VEHTRACK_ALARM add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_ALARM.VEHICLE_SHAPE is '��������';
--������Ϣ��T_VEHTRACK_VEHICLE���ӳ��������ֶ�
alter table T_VEHTRACK_VEHICLE add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_VEHICLE.VEHICLE_SHAPE is '��������';
--�ص㳵����Ϣ��T_VEHTRACK_IMPORTANT_VEH���ӳ��������ֶ�
alter table T_VEHTRACK_IMPORTANT_VEH add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_IMPORTANT_VEH.VEHICLE_SHAPE is '��������';
--��������¼��T_VEHTRACK_CHECK_REGISTER���ӳ��������ֶ�
alter table T_VEHTRACK_CHECK_REGISTER add VEHICLE_SHAPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_CHECK_REGISTER.VEHICLE_SHAPE is '��������';

--����ά������code_type��codeֵ
insert into t_sys_code_type (CODE_TYPE, CODE_TYPE_NAME, ENGLISH_NAME,EDITABLE, REGEX, ENABLE_FLAG)
values ('483', 'ά������','MAINTENANCE_CYCLE', '1', null, '1');

insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('483', '1', 'һ����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('483', '2', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('483', '3', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('483', '4', '������', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('483', '5', 'һ��', '1', '1', null, null);

--2015/12/11  ���
--����������������
CREATE TABLE T_TRAFFIC_DAILY_FLOW 
(
   SECTION_STATE_ID     VARCHAR2(32)         NOT NULL,
   SECTION_ID           VARCHAR2(32)         NOT NULL,
   TOTAL_NUM            NUMBER(6),
   LARGE_NUM            NUMBER(6),
   SMALL_NUM            NUMBER(6),
   OTHER_NUM            NUMBER(6),
   AVR_SPEED            NUMBER(6,2),
   VEH_TAIL_SPACE       NUMBER(6,2),
   UPDATE_TIME          DATE                 NOT NULL,
   ORG_PRIVILEGE_CODE   VARCHAR2(8)          NOT NULL,
   CONSTRAINT PK_T_TRAFFIC_DAILY_FLOW PRIMARY KEY (SECTION_STATE_ID)
);

COMMENT ON TABLE T_TRAFFIC_DAILY_FLOW IS
'����ÿ��������';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.SECTION_STATE_ID IS
'��������ID';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.SECTION_ID IS
'����ID';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.TOTAL_NUM IS
'�ܳ���';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.LARGE_NUM IS
'����';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.SMALL_NUM IS
'С����';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.OTHER_NUM IS
'��������';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.AVR_SPEED IS
'ƽ������';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.VEH_TAIL_SPACE IS
'��ͷʱ��';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.UPDATE_TIME IS
'���ݸ���ʱ��';

COMMENT ON COLUMN T_TRAFFIC_DAILY_FLOW.ORG_PRIVILEGE_CODE IS
'����Ȩ�޹��˴��롣���������������ʡ�ܶӱ�����2λ��ʾ��34���ܶ������֧����4λ�����ʾ��3401�������6λ�����ʾ��340101���ж���8λ�����ʾ��34010101��֧�ӡ���ӡ��жӰ�������֧�ӡ���ӵȻ����������ϵͳ�Զ����ɡ�';

--���Ӷ�������������������ID�������С�
--����sequence
create sequence SEQ_T_FLOW_DAILY
minvalue 1
maxvalue 99999999999
start with 1
increment by 1
cache 20;

--����trigger
create or replace trigger TRIG_T_FLOW_DAILY
  before insert on T_TRAFFIC_DAILY_FLOW
  for each row
begin
  if(:new.SECTION_STATE_ID is null or :new.SECTION_STATE_ID = '') then
  select SEQ_T_FLOW_DAILY.nextval into :new.SECTION_STATE_ID from dual;
  end if;
end TRIG_T_FLOW_DAILY;

--�˹���Ԥ·��������REGION_ID
alter table T_TRAFFIC_MANUAL_STATE add REGIONAL_ID VARCHAR2(32);
COMMENT ON COLUMN T_TRAFFIC_MANUAL_STATE.REGIONAL_ID is '����ID';

--2015/12/14  ��ܣ��������Ѿ����£�
--5����������Сʱ������������������ϵͳ����ֶ�
alter table T_TRAFFIC_SECTION_FLOW add DEVICE_SYS_NBR VARCHAR2(18);
alter table T_TRAFFIC_ONE_HOUR_FLOW add DEVICE_SYS_NBR VARCHAR2(18);
alter table T_TRAFFIC_DAILY_FLOW add DEVICE_SYS_NBR VARCHAR2(18);

--��λ�����ӻ���Ȩ�޹��˴���
alter table T_SYS_SITE add ORG_PRIVILEGE_CODE VARCHAR2(8);
COMMENT ON COLUMN T_SYS_SITE.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--���µ�λ�����Ȩ�޴����ֵ
update t_sys_site t set t.org_privilege_code = (
       select o.org_privilege_code from t_sys_org o where o.org_id = t.org_id
);

--����װ����
CREATE TABLE T_DEVICE_EQUIPMENT 
(
   EQUIPMENT_ID         VARCHAR2(32)         NOT NULL,
   EQUIPMENT_NBR        VARCHAR2(18),
   INTEGRATE_PLATFORM_NBR VARCHAR2(32),
   EQUIPMENT_TYPE       VARCHAR2(2)          NOT NULL,
   EQUIPMENT_NAME       VARCHAR2(32),
   ORG_ID               VARCHAR2(32)         NOT NULL,
   ORG_PRIVILEGE_CODE   VARCHAR2(8)          NOT NULL,
   CONTRACT_ID          VARCHAR2(32),
   CONTRACTOR_ID        VARCHAR2(32),
   DEVICE_SYS_MODEL_ID  VARCHAR2(32),
   DEVICE_BRAND         VARCHAR2(32),
   SPECIFICATION        VARCHAR2(128),
   MANUFACTURE_SN       VARCHAR2(32),
   SOFTWARE_VERSION     VARCHAR2(32),
   INSTALL_DATE         DATE,
   USE_STATUS_FLAG      CHAR(1)              NOT NULL,
   ENABLE_UPDATE_DATE   DATE,
   CREATE_BY            VARCHAR2(32),
   CREATE_TIME          DATE                 NOT NULL,
   UPDATE_BY            VARCHAR2(32),
   UPDATE_TIME          DATE,
   REMARK               VARCHAR2(32),
   CONSTRAINT PK_T_DEVICE_EQUIPMENT PRIMARY KEY (EQUIPMENT_ID)
);

COMMENT ON TABLE T_DEVICE_EQUIPMENT IS
'����װ����';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.EQUIPMENT_ID IS
'װ��ID';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.EQUIPMENT_NBR IS
'װ�����';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.INTEGRATE_PLATFORM_NBR IS
'�ۺ�ƽ̨�ǼǱ��';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.EQUIPMENT_TYPE IS
'װ�����ͣ�
1 �Ƽ�
2 ִ����¼��
3 GPS';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.EQUIPMENT_NAME IS
'װ������';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.ORG_ID IS
'����ID';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.ORG_PRIVILEGE_CODE IS
'����Ȩ�޹��˴��롣���������������ʡ�ܶӱ�����2λ��ʾ��34���ܶ������֧����4λ�����ʾ��3401�������6λ�����ʾ��340101���ж���8λ�����ʾ��34010101��֧�ӡ���ӡ��жӰ�������֧�ӡ���ӵȻ����������ϵͳ�Զ����ɡ�';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.CONTRACT_ID IS
'��ͬID';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.CONTRACTOR_ID IS
'�н���ID';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.DEVICE_SYS_MODEL_ID IS
'ϵͳ�ͺ�ID';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.DEVICE_BRAND IS
'Ʒ��';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.SPECIFICATION IS
'���';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.MANUFACTURE_SN IS
'�������к�';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.SOFTWARE_VERSION IS
'����汾';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.INSTALL_DATE IS
'��װ����';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.USE_STATUS_FLAG IS
'ʹ��״̬��ʶ��
1 ����
2 ͣ��
3 ����
';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.ENABLE_UPDATE_DATE IS
'ʹ��״̬����ʱ��';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.CREATE_BY IS
'������';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.CREATE_TIME IS
'����ʱ��';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.UPDATE_BY IS
'������Ա';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.UPDATE_TIME IS
'����ʱ��';

COMMENT ON COLUMN T_DEVICE_EQUIPMENT.REMARK IS
'��ע';

--ͼƬ���춨��Ϣ��ʹ��״̬��¼������װ��ID�ֶ�
alter table T_DEVICE_PHOTO add EQUIPMENT_ID VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_PHOTO.EQUIPMENT_ID is 'װ��ID';

alter table T_DEVICE_CERTIFICATION add EQUIPMENT_ID VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_CERTIFICATION.EQUIPMENT_ID is 'װ��ID';

alter table T_DEVICE_SYS_USE_STATUS add EQUIPMENT_ID VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_SYS_USE_STATUS.EQUIPMENT_ID is 'װ��ID';

--����װ������code_type��codeֵ
insert into t_sys_code_type (CODE_TYPE, CODE_TYPE_NAME, ENGLISH_NAME,EDITABLE, REGEX, ENABLE_FLAG)
values ('484', 'װ������','EQUIPMENT_TYPE', '1', null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('484', '1', '�Ƽ�', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('484', '2', 'ִ����¼��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('484', '3', 'GPS', '1', '1', null, null);

--·�α����ӻ���Ȩ�޹��˴���
alter table T_SYS_ROAD_SECTION add ORG_PRIVILEGE_CODE VARCHAR2(8);
COMMENT ON COLUMN T_SYS_ROAD_SECTION.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--��·�����ӻ���Ȩ�޹��˴���
alter table T_SYS_ROAD add ORG_PRIVILEGE_CODE VARCHAR2(8);
COMMENT ON COLUMN T_SYS_ROAD.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--·�ڱ����ӻ���Ȩ�޴����ֶ�
alter table T_SYS_CROSS add ORG_PRIVILEGE_CODE VARCHAR2(8);
COMMENT ON COLUMN T_SYS_CROSS.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--����·�α��еĻ���Ȩ�޹��˴����ֵ
update t_sys_road_section s
   set s.org_privilege_code =
       (select o.org_privilege_code
          from t_sys_org o
         where s.org_id = o.org_id);

--����·�ڱ��еĻ���Ȩ�޹��˴���
update T_SYS_CROSS s
   set s.org_privilege_code =
       (select o.org_privilege_code
          from t_sys_org o
         where s.org_id = o.org_id);

--������������ƽ�������ֶ���
alter table T_TRAFFIC_DAILY_FLOW rename column AVR_SPEED to AVG_SPEED;

--����Сʱ������ƽ�������ֶ���
alter table T_TRAFFIC_ONE_HOUR_FLOW rename column AVR_SPEED to AVG_SPEED;

--����5����������ƽ�������ֶ���
alter table T_TRAFFIC_SECTION_FLOW rename column AVR_SPEED to AVG_SPEED;

--��������������ƽ�����١�ƽ������ʱ���ֶ���
alter table T_TRAFFIC_REGION_FLOW rename column AVR_SPEED to AVG_SPEED;
alter table T_TRAFFIC_REGION_FLOW rename column AVR_TRAVEL_TIME to AVG_TRAVEL_TIME;

--ɾ��ϵͳ����code_type��codeֵ
delete from t_sys_code where code_type='007';
delete from t_sys_code_type where code_type='007';

--���ĵ�·���ֶγ���
alter table t_sys_road modify ORG_PRIVILEGE_CODE VARCHAR2(256);


--2015/12/15  ���
--��ֵ��������35������
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('508', '35', '����', '1', '1', null, null);

--�½��豸��װ������ͼ
create or replace view v_device_equipment as
select device_id,
       device_sys_model_id,
       contract_id,
       device_sys_nbr,
       device_name,
       org_id,
       device_type,
       device_brand,
       manufacture_sn,
       software_version,
       network_type,
       safe_connect_means,
       device_ip,
       device_port,
       user_name,
       password,
       sim_nbr,
       install_date,
       install_by,
       mounting_facility_type,
       enable_update_date,
       use_status_flag,
       longitude,
       latitude,
       status_type,
       status_update_time,
       sync_status,
       create_by,
       create_time,
       update_by,
       update_time,
       remark,
       power_type,
       transmission_mode,
       bandwidth,
       ownership,
       site_id,
       section_id_list,
       server_group_type_id,
       collection_type,
       start_time,
       end_time,
       road_id,
       org_privilege_code,
       contractor_id,
        '1' as record_type
  from t_device_sys
union all
select equipment_id as device_id,
       device_sys_model_id,
       contract_id,
       equipment_nbr as device_sys_nbr,
       equipment_name as device_name,
       org_id,
       equipment_type as device_type,
       device_brand,
       manufacture_sn,
       software_version,
       '' as network_type,
       '' as safe_connect_means,
       '' as device_ip,
       null as device_port,
       '' as user_name,
       '' as password,
       '' as sim_nbr,
       install_date,
       '' as install_by,
       '' as mounting_facility_type,
       enable_update_date,
       use_status_flag,
       null as longitude,
       null as latitude,
       '' as status_type,
       null as status_update_time,
       '' as sync_status,
       create_by,
       create_time,
       update_by,
       update_time,
       remark,
       '' as power_type,
       '' as transmission_mode,
       '' as bandwidth,
       '' as ownership,
       '' as site_id,
       '' as section_id_list,
       '' as server_group_type_id,
       '' as collection_type,
       null as start_time,
       null as end_time,
       '' as road_id,
       org_privilege_code,
       contractor_id,
        '0' as record_type
  from t_device_equipment;

--ɾ���豸ͼƬ����װ��ID�ֶ�
alter table T_DEVICE_PHOTO drop (EQUIPMENT_ID);

--ɾ���춨��װ��ID�ֶ�
alter table T_DEVICE_CERTIFICATION drop (EQUIPMENT_ID);

--ɾ��ʹ��״̬��װ��ID�ֶ�
alter table T_DEVICE_SYS_USE_STATUS drop (EQUIPMENT_ID);

--ɾ������5����������ϵͳ����ֶ�
alter table T_TRAFFIC_SECTION_FLOW drop (DEVICE_SYS_NBR);

--ɾ������Сʱ������ϵͳ����ֶ�
alter table T_TRAFFIC_ONE_HOUR_FLOW drop (DEVICE_SYS_NBR);


--2015-12-16 
--����ͳ�Ʒ����˵�
delete from T_SYS_MENU t where t.menu_code like '0601%';

insert into T_SYS_MENU (MENU_CODE, SYS_CONFIG_ID, MENU_NAME, TARGET_URL, PARENT_CODE, SORT_INDEX, MENU_ENABLE_FLAG, REMARK, MENU_IMAGE_URL)values ('0601', '0601', '���ڹ�������', null, '06', '1', '1', null, 'themes/default/images/a1.png');

insert into T_SYS_MENU (MENU_CODE, SYS_CONFIG_ID, MENU_NAME, TARGET_URL, PARENT_CODE, SORT_INDEX, MENU_ENABLE_FLAG, REMARK, MENU_IMAGE_URL)values ('060101', '060101', '���㿨�ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/single-site-flow-analysis.html', '0601', '1', '1', null, 'themes/default/images/a1.png');

insert into T_SYS_MENU (MENU_CODE, SYS_CONFIG_ID, MENU_NAME, TARGET_URL, PARENT_CODE, SORT_INDEX, MENU_ENABLE_FLAG, REMARK, MENU_IMAGE_URL)values ('060102', '060102', '��·���ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/road-flow-analysis.html', '0601', '2', '1', null, 'themes/default/images/a1.png');

insert into T_SYS_MENU (MENU_CODE, SYS_CONFIG_ID, MENU_NAME, TARGET_URL, PARENT_CODE, SORT_INDEX, MENU_ENABLE_FLAG, REMARK, MENU_IMAGE_URL)values ('060103', '060103', 'Ͻ�����ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/district-flow-analysis.html', '0601', '3', '1', null, 'themes/default/images/a1.png');

insert into T_SYS_MENU (MENU_CODE, SYS_CONFIG_ID, MENU_NAME, TARGET_URL, PARENT_CODE, SORT_INDEX, MENU_ENABLE_FLAG, REMARK, MENU_IMAGE_URL)values ('060104', '060104', '��㿨�ڷ���', 'tpls/statisticsAnalysis/flowAnalysis/multi-site-flow-analysis.html', '0601', '4', '1', null, 'themes/default/images/a1.png');
--���ӵ�·�����
create table MAP_ROAD
(
  name        VARCHAR2(100),
  kind        VARCHAR2(30),
  popname     VARCHAR2(50),
  direction   NUMBER,
  district    VARCHAR2(10),
  type        NUMBER,
  length      NUMBER,
  lanes       NUMBER,
  formofway   NUMBER,
  updatetime  NUMBER,
  policearea  VARCHAR2(10),
  wkt         CLOB,
  id          VARCHAR2(10),
  cyid        VARCHAR2(10),
  road_code   VARCHAR2(6),
  regional_id VARCHAR2(32),
  froadname   VARCHAR2(64),
  broadname   VARCHAR2(64)
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16K
    next 8K
    minextents 1
    maxextents unlimited
  );
--��ӵ�·�����������
--ִ�б�Ŀ¼�¡�modify_sql�������ļ����еġ�maproad.dmp��

--���ͳ�Ʒ�����ر����ͼ
--ִ�б�Ŀ¼�¡�modify_sql�������ļ����еġ�����ͳ�Ʊ���������.sql��
--ִ�б�Ŀ¼�¡�modify_sql�������ļ����еġ���������ͼ.sql��

--2015-12-17 ����
--���Ӻ���������idת���ɻ���Ȩ�ޱ��룬֧�ֶ��ŷָ���ʽ
create or replace function convert_orgids_to_prv_code(ids varchar2) return varchar2 is
  result varchar2(256);
  lv_str varchar2(256);
  item_str varchar2(32);
  org_code_str varchar2(32);
begin
  lv_str := ids || ',';
  while instr(lv_str,',')<>0 loop
     org_code_str := substr(lv_str,1,instr(lv_str,',')-1);
     lv_str:=substr(lv_str,instr(lv_str,',')+1,length(lv_str));
     dbms_output.put_line(org_code_str);  
     select o.org_privilege_code into item_str from t_sys_org o where o.org_id = org_code_str;
     dbms_output.put_line(item_str); 
     result := result || item_str || ',';
  end loop;
  return(substr(result,1,length(result)-1));
end convert_orgids_to_prv_code;
--����·���еĻ���Ȩ�ޱ��븳ֵ
update t_sys_road r set r.org_privilege_code = convert_orgids_to_prv_code(r.org_id);
--���²˵�ͼƬurl
update t_sys_menu m set m.menu_image_url = 'themes/default/images/clck.png' where m.menu_code = '01';
update t_sys_menu m set m.menu_image_url = 'themes/default/images/wfgl.png' where m.menu_code = '02';
update t_sys_menu m set m.menu_image_url = 'themes/default/images/sbyw.png' where m.menu_code = '03';
update t_sys_menu m set m.menu_image_url = 'themes/default/images/lkjk.png' where m.menu_code = '04';
update t_sys_menu m set m.menu_image_url = 'themes/default/images/xtgl.png' where m.menu_code = '05';
update t_sys_menu m set m.menu_image_url = 'themes/default/images/tjfx.png' where m.menu_code = '06';

--�豸ϵͳ��Ͳ���������device_key�ֶ�
alter table t_device_sys add  device_key VARCHAR2(64);
alter table t_device_sys_component add  device_key VARCHAR2(64);

--������������Сʱ������
create table ITMS3.X_F_D_FLOW
(
  flow_id            VARCHAR2(32) not null,
  district_code      VARCHAR2(6),
  road_code          VARCHAR2(6),
  site_code          VARCHAR2(16) not null,
  device_sys_nbr     VARCHAR2(18) not null,
  direction_type     VARCHAR2(2),
  direction_name     VARCHAR2(32),
  lane               VARCHAR2(2),
  count_time         DATE not null,
  total_num          NUMBER(6),
  avr_speed          NUMBER(6,2),
  avr_length         NUMBER(6,2),
  large_num          NUMBER(6),
  middle_num         NUMBER(6),
  small_num          NUMBER(6),
  motor_num          NUMBER(6),
  supper_len_veh_num NUMBER(6,2),
  other_num          NUMBER(6),
  org_privilege_code VARCHAR2(8),
  create_time        DATE
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_F_D_FLOW
  is '�����������';
comment on column ITMS3.X_F_D_FLOW.flow_id
  is '����ID';
comment on column ITMS3.X_F_D_FLOW.site_code
  is '��λ����';
comment on column ITMS3.X_F_D_FLOW.device_sys_nbr
  is 'ϵͳ���';
comment on column ITMS3.X_F_D_FLOW.direction_type
  is '��������';
comment on column ITMS3.X_F_D_FLOW.lane
  is '����';
comment on column ITMS3.X_F_D_FLOW.count_time
  is 'ͳ��ʱ��';
comment on column ITMS3.X_F_D_FLOW.total_num
  is '�ܳ���';
comment on column ITMS3.X_F_D_FLOW.avr_speed
  is 'ƽ������';
comment on column ITMS3.X_F_D_FLOW.large_num
  is '����';
comment on column ITMS3.X_F_D_FLOW.middle_num
  is '���ͳ���';
comment on column ITMS3.X_F_D_FLOW.small_num
  is 'С����';
comment on column ITMS3.X_F_D_FLOW.motor_num
  is 'Ħ�г���';
comment on column ITMS3.X_F_D_FLOW.supper_len_veh_num
  is '����������';
comment on column ITMS3.X_F_D_FLOW.other_num
  is '��������';
comment on column ITMS3.X_F_D_FLOW.org_privilege_code
  is '����Ȩ�޹��˴���';
alter table ITMS3.X_F_D_FLOW
  add constraint PK_X_F_D_FLOW primary key (FLOW_ID)
  using index 
  tablespace ITMS_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

create table ITMS3.X_F_H_FLOW
(
  flow_id            VARCHAR2(32) not null,
  district_code      VARCHAR2(6),
  road_code          VARCHAR2(6),
  site_code          VARCHAR2(16) not null,
  device_sys_nbr     VARCHAR2(18) not null,
  direction_type     VARCHAR2(2),
  direction_name     VARCHAR2(32),
  lane               VARCHAR2(2),
  count_time         DATE not null,
  total_num          NUMBER(6),
  avr_speed          NUMBER(6,2),
  avr_length         NUMBER(6,2),
  large_num          NUMBER(6),
  middle_num         NUMBER(6),
  small_num          NUMBER(6),
  motor_num          NUMBER(6),
  supper_len_veh_num NUMBER(6,2),
  other_num          NUMBER(6),
  org_privilege_code VARCHAR2(8),
  create_time        DATE
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table ITMS3.X_F_H_FLOW
  is '�����������';
comment on column ITMS3.X_F_H_FLOW.flow_id
  is '����ID';
comment on column ITMS3.X_F_H_FLOW.site_code
  is '��λ����';
comment on column ITMS3.X_F_H_FLOW.device_sys_nbr
  is 'ϵͳ���';
comment on column ITMS3.X_F_H_FLOW.direction_type
  is '��������';
comment on column ITMS3.X_F_H_FLOW.lane
  is '����';
comment on column ITMS3.X_F_H_FLOW.count_time
  is 'ͳ��ʱ��';
comment on column ITMS3.X_F_H_FLOW.total_num
  is '�ܳ���';
comment on column ITMS3.X_F_H_FLOW.avr_speed
  is 'ƽ������';
comment on column ITMS3.X_F_H_FLOW.large_num
  is '����';
comment on column ITMS3.X_F_H_FLOW.middle_num
  is '���ͳ���';
comment on column ITMS3.X_F_H_FLOW.small_num
  is 'С����';
comment on column ITMS3.X_F_H_FLOW.motor_num
  is 'Ħ�г���';
comment on column ITMS3.X_F_H_FLOW.supper_len_veh_num
  is '����������';
comment on column ITMS3.X_F_H_FLOW.other_num
  is '��������';
comment on column ITMS3.X_F_H_FLOW.org_privilege_code
  is '����Ȩ�޹��˴���';
alter table ITMS3.X_F_H_FLOW
  add constraint PK_X_F_H_FLOW primary key (FLOW_ID)
  using index 
  tablespace ITMS_DATA
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
  
  --20151218 �𺣲� ��Ƶ��ر��޸�
alter table t_traffic_plan_log modify video_plan_end_time DATE null;

alter table t_traffic_video_log modify video_plan_end_time DATE null;

update t_sys_menu set menu_name='Ѳ����־' ,target_url='tpls/trafficMonitor/videoMonitor/cruise-log-list.html' where sys_config_id='040404';

alter table t_traffic_video_log add place varchar2(128);
comment on column T_TRAFFIC_VIDEO_LOG.place
  is '�����ص�';
  
alter table t_device_sys modify device_sys_nbr varchar2(32);

--20151222 ͳ�Ʊ������
--ִ�б�Ŀ¼�¡�modify_sql�������ļ����еġ�t_sys_function_insert(20151222).sql��
--ִ�б�Ŀ¼�¡�modify_sql�������ļ����еġ�t_sys_menu_insert(20151222).sql��
--ִ�б�Ŀ¼�¡�modify_sql�������ļ����еġ�������,����(20151222).sql��

--2015/12/28 ���
--���ͼƬ���춨��Ϣ��ʹ��״̬��¼��������
delete from t_device_photo; 
delete from T_DEVICE_CERTIFICATION; 
delete from T_DEVICE_SYS_USE_STATUS; 

--���Ӽ춨��Ϣ��װ����������ϵ
ALTER TABLE T_DEVICE_CERTIFICATION
   ADD CONSTRAINT FK_T_DEVICE_EQUIPMENT FOREIGN KEY (DEVICE_ID)
      REFERENCES T_DEVICE_EQUIPMENT (EQUIPMENT_ID) ON DELETE CASCADE;

--����ͼƬ��Ϣ��װ����������ϵ
ALTER TABLE T_DEVICE_PHOTO
   ADD CONSTRAINT FK_T_DEVICE_PHOTO_EQUIPMENT FOREIGN KEY (DEVICE_ID)
      REFERENCES T_DEVICE_EQUIPMENT (EQUIPMENT_ID) ON DELETE CASCADE;

--����ʹ��״̬��¼����װ����������ϵ
ALTER TABLE T_DEVICE_SYS_USE_STATUS
   ADD CONSTRAINT FK_T_USE_STATUS_EQUIPMENT FOREIGN KEY (DEVICE_ID)
      REFERENCES T_DEVICE_EQUIPMENT (EQUIPMENT_ID);

--�޸��˹��ϱ��¼�����·ID�ֶβ�Ϊ��
ALTER TABLE T_traffic_manual_event modify ROAD_ID not null;
--�޸Ľ�ͨ���Ʊ�����ID����ʼʱ�䣬����ʱ�䲻Ϊ��
ALTER TABLE T_TRAFFIC_CONTROL modify ORG_ID not null;
ALTER TABLE T_TRAFFIC_CONTROL modify START_TIME not null;
ALTER TABLE T_TRAFFIC_CONTROL modify END_TIME not null;
--�޸��˹���¼�����������������Ͳ�Ϊ��
ALTER TABLE T_TRAFFIC_MANUAL_WEATHER modify METEOROLOGY_TYPE not null;

--���ӽ�ͨ���Ʒ���code_type��ֵ
insert into t_sys_code_type (CODE_TYPE, CODE_TYPE_NAME, ENGLISH_NAME,EDITABLE, REGEX, ENABLE_FLAG)
values ('515', '���Ʒ���','DIRECTION_TYPE', '1', null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('515', '0', '˫��', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('515', '1', '����', '1', '1', null, null);
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, ENABLE_FLAG, SORT_INDEX, REMARK)
values ('515', '2', '����', '1', '1', null, null);

--ɾ��ͼƬ���춨��Ϣ��ʹ��״̬��¼���Լ��
ALTER TABLE t_device_photo drop CONSTRAINT FK_T_DEVICE_PHOTO_EQUIPMENT;
ALTER TABLE t_device_photo drop CONSTRAINT RELATIONSHIP_5;
ALTER TABLE T_DEVICE_CERTIFICATION drop CONSTRAINT FK_T_DEVICE_EQUIPMENT;
ALTER TABLE T_DEVICE_CERTIFICATION drop CONSTRAINT RELATIONSHIP_6;
ALTER TABLE T_DEVICE_SYS_USE_STATUS drop CONSTRAINT FK_T_USE_STATUS_EQUIPMENT;
ALTER TABLE T_DEVICE_SYS_USE_STATUS drop CONSTRAINT RELATIONSHIP_9;

--���Ƴ�������¼�����ӹ���ͼƬ1URL������ͼƬ2URL
ALTER TABLE T_VEHTRACK_CLONE_VEHICLE add IMAGE_URL1 VARCHAR2(128);
ALTER TABLE T_VEHTRACK_CLONE_VEHICLE add IMAGE_URL2 VARCHAR2(128);
COMMENT ON COLUMN T_VEHTRACK_CLONE_VEHICLE.IMAGE_URL1 is '����ͼƬ1';
COMMENT ON COLUMN T_VEHTRACK_CLONE_VEHICLE.IMAGE_URL2 is '����ͼƬ2';

--���Ӽ��ϵͳ��DEVICE_KEYΪ�ɿ�
ALTER TABLE T_DEVICE_SYS modify device_key null;
ALTER TABLE T_DEVICE_SYS_COMPONENT modify device_key null;

--2015/12/29 ���
--ϵͳ����������������ֶ�
ALTER TABLE T_DEVICE_SYS_COMPONENT add COMPONENT_NAME VARCHAR2(128);
COMMENT ON COLUMN T_DEVICE_SYS_COMPONENT.COMPONENT_NAME is '�������';

--t_device_video������access_mode(char(1))����������Ƶ���뷽ʽϵͳ����
alter table t_device_video add access_mode(char(1)));
comment on column t_device_video.access_mode  is '������뷽ʽ';
insert into T_SYS_CODE_TYPE (CODE_TYPE, CODE_TYPE_NAME, EDITABLE, REGEX, ENABLE_FLAG, ENGLISH_NAME)
values ('485', '������뷽ʽ', '1', null, '1', 'ACCESS_MODE');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '485', '1', '����ƽ̨', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '485', '2', '����ֱ���豸', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '485', '3', '��ƽ̨', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '485', '4', '��ֱ���豸', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '485', '5', '��Զƽ̨', '1', null, null, '1'); 

--2015/12/30 ���
--�����������ݴ���켣��
CREATE TABLE T_DEVICE_DATA_PATH 
(
   DATA_PATH_ID         VARCHAR2(32)         NOT NULL,
   DEVICE_SYS_NBR       VARCHAR2(18)         NOT NULL,
   DEVICE_NBR           VARCHAR2(18),
   SNAP_NBR             VARCHAR2(32)         NOT NULL,
   PASS_TIME            DATE                 NOT NULL,
   SERVER_RECEIVING_TIME DATE,
   ICE2MQ_TIME          DATE,
   PRE_TIME             DATE,
   AFTER_TIME           DATE,
   UPLOAD_TIME          DATE                 NOT NULL,
   UPLOAD_END_TIME      DATE                 NOT NULL,
   TOTAL_TIME           NUMBER(12��2),
   CONSTRAINT PK_T_DEVICE_DATA_PATH PRIMARY KEY (DATA_PATH_ID)
);

COMMENT ON TABLE T_DEVICE_DATA_PATH IS
'��¼���������ڴ�������е�ʱ��켣';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.DATA_PATH_ID IS
'��¼ID';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.DEVICE_SYS_NBR IS
'ϵͳ���';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.DEVICE_NBR IS
'�豸���';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.SNAP_NBR IS
'ץ�ı��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.PASS_TIME IS
'����ʱ��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.SERVER_RECEIVING_TIME IS
'��ط���������ʱ��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.ICE2MQ_TIME IS
'ICE2MQ����ʱ��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.PRE_TIME IS
'ǰ�û�����ʱ��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.AFTER_TIME IS
'���û�����ʱ��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.UPLOAD_TIME IS
'�ϴ���ʼʱ��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.UPLOAD_END_TIME IS
'�ϴ�����ʱ��';

COMMENT ON COLUMN T_DEVICE_DATA_PATH.TOTAL_TIME IS
'�ܺ�ʱ����λΪ�롣';

--�������ͣ����У���071��code_noȫ������2
update t_sys_code set code_no=code_no+2 where code_type='071';

--ϵͳ�齨�����ӳ�������ֶ�
alter table T_DEVICE_SYS_COMPONENT add LANE_NBR VARCHAR2(32);
COMMENT ON COLUMN T_DEVICE_SYS_COMPONENT.LANE_NBR is'�������';

--2015/12/31 ���
--�˵����������ݴ���켣ֵ
insert into T_SYS_MENU (MENU_CODE, SYS_CONFIG_ID, MENU_NAME, TARGET_URL, PARENT_CODE, SORT_INDEX, MENU_ENABLE_FLAG, REMARK, MENU_IMAGE_URL)
values ('030602', '030602', '���ݴ���켣�鿴', 'tpls/deviceManage/systemMaintainManage/data-transmission-path.html', '0306', '2', '1', null, 'themes/default/images/a1.png');

--�������ݴ���켣������device_key�ֶ�
alter table T_DEVICE_DATA_PATH add DEVICE_KEY VARCHAR2(64);
COMMENT ON COLUMN T_DEVICE_DATA_PATH.DEVICE_KEY is 'Ψһֵ';

--�������ݹ켣��ɾ��ϵͳ����ֶ�
alter table  T_DEVICE_DATA_PATH drop (DEVICE_SYS_NBR);

--�޸��������·ID�ֶγ���Ϊ32λ
alter table T_DEVICE_REGION modify ROAD_ID VARCHAR2(32);

--2016/1/4 ���
--�������ݴ���켣�����ӵ��Ӽ��ϵͳid�����ID������Ȩ�޹��˴����ֶ�
alter table T_DEVICE_DATA_PATH add DEVICE_ID VARCHAR2(32) not null;
alter table T_DEVICE_DATA_PATH add SYS_COMPONENT_ID VARCHAR2(32);
alter table T_DEVICE_DATA_PATH add ORG_PRIVILEGE_CODE VARCHAR2(8) not null;
COMMENT ON COLUMN T_DEVICE_DATA_PATH.DEVICE_ID is '���Ӽ��ϵͳID';
COMMENT ON COLUMN T_DEVICE_DATA_PATH.SYS_COMPONENT_ID is '���ID';
COMMENT ON COLUMN T_DEVICE_DATA_PATH.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--�������ݴ���켣��ɾ���豸����ֶ�
alter table T_DEVICE_DATA_PATH drop (DEVICE_NBR);

--2016/1/5 ���
--����Уʱ״̬�ͷ�����״̬code�Լ�code_type
insert into T_SYS_CODE_TYPE (CODE_TYPE, CODE_TYPE_NAME, EDITABLE, REGEX, ENABLE_FLAG, ENGLISH_NAME)
values ('486', 'Уʱ״̬', '1', null, '1', 'timeResult');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '486', '0', 'δУʱ', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '486', '1', 'Уʱ�ɹ�', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '486', '2', 'Уʱʧ��', '1', null, null, '1');

insert into T_SYS_CODE_TYPE (CODE_TYPE, CODE_TYPE_NAME, EDITABLE, REGEX, ENABLE_FLAG, ENGLISH_NAME)
values ('487', '����״̬', '1', null, '1', 'processStatus');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '487', '0', '����', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '487', '1', '����', '1', null, null, '1');
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '487', '2', '�쳣', '1', null, null, '1');

--�޸ĵ�·�������·ID�ֶ�Ϊ32λ
alter table  T_SYS_REGION modify ROAD_ID VARCHAR2(32);

--�����������device_key��ֵ
update T_DEVICE_SYS_COMPONENT c set c.device_key=c.device_nbr where c.device_key is null;

--������Ƶ�豸device_key��ֵ
update t_device_sys d
   set d.device_key = d.device_sys_nbr
 where d.device_type = '03'
   and d.device_key is null;

--2016/1/6 ���
--�޸Ĳ˵��������ݴ���켣�˵�����״̬
update T_SYS_MENU set menu_enable_flag='0' where menu_code='030601';

---�޸Ŀ��ڲ��������鲼��ϵͳ��ſ�Ϊ��
alter table T_DEVICE_TOLLGATE_SYS modify TRACK_SYS_TOLLGATE_NBR null;

--2016/1/8 ���
--�޸ĵ��Ӽ��ϵͳʹ��״̬��¼������ʹ��״̬����ʱ���ֶ�
alter table T_DEVICE_SYS_USE_STATUS add STATUS_END_TIME date ;
COMMENT ON COLUMN T_DEVICE_SYS_USE_STATUS.STATUS_END_TIME is '״̬����ʱ��';

--�޸Ĺ��������ͼ��λ���Լ�����ͼ��λ�ó���
alter table T_VEHTRACK_PASS modify VEHICLE_PLATE_PLACE VARCHAR2(128);
alter table T_VEHTRACK_PASS modify FACE_PLACE VARCHAR2(128);


--2016/1/11 ���
--�޸Ĺ���������Ƿ������ֶ�����
alter table T_VEHTRACK_PASS rename column ERTRANCE_OR_EXIT to ENTRANCE_OR_EXIT;

--�޸��˹���¼����������org_code->org_id
alter table T_TRAFFIC_MANUAL_WEATHER rename column ORG_CODE to ORG_ID;
COMMENT ON COLUMN T_TRAFFIC_MANUAL_WEATHER.ORG_ID is '����ID';
alter table T_TRAFFIC_MANUAL_WEATHER modify ORG_ID VARCHAR2(32);

--�޸ĵ�·�¼��˹���¼��org_code->org_id
alter table T_TRAFFIC_MANUAL_EVENT rename column ORG_CODE to ORG_ID;
COMMENT ON COLUMN T_TRAFFIC_MANUAL_EVENT.ORG_ID is '����ID';
alter table T_TRAFFIC_MANUAL_EVENT modify ORG_ID VARCHAR2(32);

--��ͨ���Ʊ����ӻ���Ȩ�޴���
alter table T_TRAFFIC_CONTROL add ORG_PRIVILEGE_CODE VARCHAR2(8);
COMMENT ON COLUMN T_TRAFFIC_CONTROL.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';

--������Ƶ�û�����𺣲�
-- Create table
create table T_TRAFFIC_VIDEO_GROUP
(
group_id VARCHAR2(32) not null,
group_name VARCHAR2(32) not null,
create_user VARCHAR2(32) not null,
create_time DATE not null,
update_time DATE,
org_authority_code VARCHAR2(32) not null,
remark VARCHAR2(256),
group_content VARCHAR2(2048) not null
)
tablespace ITMS_DATA
pctfree 10
initrans 1
maxtrans 255;
-- Add comments to the columns 
comment on column T_TRAFFIC_VIDEO_GROUP.group_id
is '��Ƶ��id';
comment on column T_TRAFFIC_VIDEO_GROUP.group_name
is '��Ƶ������';
comment on column T_TRAFFIC_VIDEO_GROUP.create_user
is '�������û���';
comment on column T_TRAFFIC_VIDEO_GROUP.create_time
is '����ʱ��';
comment on column T_TRAFFIC_VIDEO_GROUP.update_time
is '����ʱ��';
comment on column T_TRAFFIC_VIDEO_GROUP.org_authority_code
is '����Ȩ�޴���';
comment on column T_TRAFFIC_VIDEO_GROUP.remark
is '��ע';
comment on column T_TRAFFIC_VIDEO_GROUP.group_content
is '��Ƶid���ϣ�ID��"|"�ָ�';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_TRAFFIC_VIDEO_GROUP
add constraint PK_TRAFFIC_VIDEO_GROUP primary key (GROUP_ID)
using index 
tablespace ITMS_DATA
pctfree 10
initrans 2
maxtrans 255;
  
--������Ƶ���һ���Ͷ����˵�����ԭ��·������²˵����
  
update t_sys_menu set sort_index=sort_index+1

insert into t_sys_menu
  (menu_code, sys_config_id, menu_name, target_url, parent_code, sort_index, menu_enable_flag, remark, menu_image_url)
values
  ('07', '07', '��Ƶ���', '', 'root', 1, 1, '', 'themes/default/images/spjk.png');
  
update t_sys_menu set menu_code='0701',sys_config_id='0701',
parent_code='07' where substr(menu_code,1,4)='0404' ;
  
update t_sys_menu set menu_code='0701'||substr(menu_code,5,2),sys_config_id='0701'||substr(sys_config_id,5,2),
parent_code='0701' where substr(menu_code,1,4)='0404' ;

update t_sys_role_permission set function_code='0701'||substr(function_code,5,4)
where substr(function_code,1,4)='0404' ;

update T_SYS_FUNCTION set function_code='0701'||substr(function_code,5,4),
menu_code='0701'||substr(function_code,5,2)
where substr(menu_code,1,4)='0404' ;

--2016/1/12 ���
--��·��������ӻ���Ȩ�޴���
alter table T_SYS_REGION add ORG_PRIVILEGE_CODE VARCHAR2(8);
COMMENT ON COLUMN T_SYS_REGION.ORG_PRIVILEGE_CODE is '����Ȩ�޹��˴���';


--2016/1/12 ��ࣨ�������Ѹ��£�
--�޸�ͳ���м���ֶγ��� 
alter table X_P_H_PASS_QTR modify(PASS_NUM number(6));
alter table X_P_H_PASS_QTR modify(PLACE_LOCAL_CITY number(6));
alter table X_P_H_PASS_QTR modify(PLACE_LOCAL_PR number(6));
alter table X_P_H_PASS_QTR modify(PLACE_OTHER_PR number(6));
alter table X_P_H_PASS_QTR modify(PLACE_MILITARY number(6));
alter table X_P_H_PASS_QTR modify(PLACE_UNKNOWN number(6));

alter table X_P_H_PASS modify(NUM_FLOW number(6));
alter table X_P_H_PASS modify(PLACE_LOCAL_CITY number(6));
alter table X_P_H_PASS modify(PLACE_LOCAL_PR number(6));
alter table X_P_H_PASS modify(PLACE_OTHER_PR number(6));
alter table X_P_H_PASS modify(PLACE_MILITARY number(6));
alter table X_P_H_PASS modify(PLACE_UNKNOWN number(6));

--��ࣨ�������Ѹ��£�
set define off
spool StatOnlineRate.log

prompt
prompt Creating procedure STATICDEVICEONLINERATE
prompt =========================================
prompt
CREATE OR REPLACE PROCEDURE ITMS3.StaticDeviceOnlineRate(orgCode      varchar2,
                                                   deviceType   varchar2,
                                                   contractId   varchar2,
                                                   contractorId varchar2,
                                                   timeWay      varchar2,
                                                   beginTime    varchar2,
                                                   endTime      varchar2,
                                                   myCursor     out sys_refcursor) IS
  orgLevel         integer;
  orgPrivilegeCode varchar2(32);
BEGIN
  select t.org_level, t.org_privilege_code
    into orgLevel, orgPrivilegeCode
    from t_sys_org t
   where t.org_code = orgCode;
  if (orglevel < 3) then
    --������ܶӻ�֧�ӣ���ʾ����������������
    if (timeWay = 'W' or timeWay = 'M') then --������ܻ����£�������ʾ������
      open mycursor for
        with org_gradation as
         (select a.org_id,
                 a.org_code,
                 a.org_name,
                 a.level_hierarchy,
                 case when a.level_hierarchy >= 3 then substr(a.collapse_hierarchy, instr(a.collapse_hierarchy, '->', 1, 2) + 2,12) else a.org_code end display_org_code
            from (select a.org_id,
                         a.org_code,
                         a.org_name,
                         level level_hierarchy,
                         sys_connect_by_path(org_code, '->') collapse_hierarchy
                    from t_sys_org a
                   where substr(a.org_privilege_code, 0, length(orgPrivilegeCode)) = orgPrivilegeCode
                   start with a.org_code = orgCode
                  connect by prior a.org_id = a.parent_instruct_org_id) a
           order by a.org_code),
        show_orgname as (select t.org_code, t.org_name from org_gradation t where t.level_hierarchy in ('1', '2'))
        select *
          from (select t.display_org_code as org_code,
                       t.org_name,
                       nvl(to_char(t.statistics_date, 'yyyy-mm-dd'), 'ƽ��') as time_stamp,
                       round(avg(primary_online), 4) primary_online,
                       round(avg(correct_online), 4) correct_online
                  from (select t.device_id,
                               statistics_date,
                               primary_online,
                               correct_online,
                               v.display_org_code,
                               r.org_name
                          from (select t.device_id,
                                       t.org_id,
                                       t.statistics_date,
                                       case when t.duration_secs is null then 0 when t.duration_secs >= 86400 then 1 else t.duration_secs / 86400 end as primary_online,
                                       case when t.correct_should_secs is null then 0 when t.duration_secs >= t.correct_should_secs then 1 else t.duration_secs / t.correct_should_secs end as correct_online
                                  from x_d_d_status_log t
                                 where t.org_id in (select a.org_id from org_gradation a)
                                   and func_varchar_filter(t.contract_id,contractId) = 'true'
                                   and func_varchar_filter(t.contractor_id, contractorId) = 'true'
                                   and decode(deviceType,NULL,'true',func_funtion_filter(deviceType, t.device_type)) = 'true'
                                   and t.stat_online = '1'
                                   and t.statistics_date >= to_date(beginTime, 'yyyy-mm-dd')
                                   and t.statistics_date <=to_date(endTime, 'yyyy-mm-dd')) t,
                               org_gradation v,
                               show_orgname r
                         where t.org_id = v.org_id(+)
                           and v.display_org_code = r.org_code(+)) t
                 group by rollup(t.display_org_code,t.org_name,t.statistics_date)
                having grouping_id(t.display_org_code, t.org_name, t.statistics_date) <= 1) 
                unpivot(online_rate for data_type in(correct_online as '2', primary_online as '1'));
    else --���� ������ʾ������
      open myCursor for
       with org_gradation as
         (select a.org_id,
                 a.org_code,
                 a.org_name,
                 a.level_hierarchy,
                 case when a.level_hierarchy >= 3 then substr(a.collapse_hierarchy, instr(a.collapse_hierarchy, '->', 1, 2) + 2,12) else a.org_code end display_org_code
            from (select a.org_id,
                         a.org_code,
                         a.org_name,
                         level level_hierarchy,
                         sys_connect_by_path(org_code, '->') collapse_hierarchy
                    from t_sys_org a
                   where substr(a.org_privilege_code, 0, length(orgPrivilegeCode)) = orgPrivilegeCode
                   start with a.org_code = orgCode
                  connect by prior a.org_id = a.parent_instruct_org_id) a
           order by a.org_code),
       show_orgname as (select t.org_code, t.org_name from org_gradation t where t.level_hierarchy in ('1', '2'))
       select * from(select t.display_org_code as org_code, 
                         t.org_name, 
                         nvl(to_char(t.statistics_month,'yyyy-mm'),'ƽ��') as time_stamp, 
                         round(avg(primary_online),4)primary_online, 
                         round(avg(correct_online),4) correct_online from( 
        select t.device_id,statistics_month, primary_online,correct_online,v.display_org_code, r.org_name 
          from (select t.device_id, 
               t.org_id, 
               t.statistics_month, 
               t.primary_online,
               t.correct_online  
          from x_d_m_status_log t  
           where t.org_id in (select a.org_id from org_gradation a)
                                   and func_varchar_filter(t.contract_id,contractId) = 'true'
                                   and func_varchar_filter(t.contractor_id, contractorId) = 'true'
                                   and decode(deviceType,NULL,'true',func_funtion_filter(deviceType, t.device_type)) = 'true'
                                   and t.stat_online = '1'
                                   and t.statistics_month >= to_date(beginTime,'yyyy-mm-dd')  
                                   and t.statistics_month <= to_date(endTime,'yyyy-mm-dd')) t, 
       org_gradation v, show_orgname r 
 where t.org_id = v.org_id(+) 
   and v.display_org_code = r.org_code(+) 
   )t group by rollup(t.display_org_code, t.org_name, t.statistics_month) 
     having grouping_id(t.display_org_code, t.org_name, t.statistics_month)<=1) unpivot(online_rate for data_type in(correct_online as  '2',primary_online as '1'));
     end if;
  else
    --����Ǵ�ӻ���ͼ����������ʾ��Ͻ���豸������
    if (timeWay = 'W' or timeWay='M') then--������ܻ����£�������ʾ������
      open myCursor for
       with org_gradation as
         (select a.org_id,
                 a.org_code,
                 a.org_name,
                 a.level_hierarchy,
                 case when a.level_hierarchy >= 3 then substr(a.collapse_hierarchy, instr(a.collapse_hierarchy, '->', 1, 2) + 2,12) else a.org_code end display_org_code
            from (select a.org_id,
                         a.org_code,
                         a.org_name,
                         level level_hierarchy,
                         sys_connect_by_path(org_code, '->') collapse_hierarchy
                    from t_sys_org a
                   where substr(a.org_privilege_code, 0, length(orgPrivilegeCode)) = orgPrivilegeCode
                   start with a.org_code = orgCode
                  connect by prior a.org_id = a.parent_instruct_org_id) a
           order by a.org_code)
        select * from(select t.org_code as org_code,
                       t.org_name,
                       nvl(to_char(t.time_stamp, 'yyyy-mm-dd'), 'ƽ��') as time_stamp,
                       round(avg(primary_online), 4) primary_online,
                       round(avg(correct_online), 4) correct_online
                  from(select t.device_id as org_code,v.device_name as org_name,t.statistics_date as time_stamp,t.primary_online,t.correct_online from(select t.device_id,
                                       t.org_id,
                                       t.statistics_date,
                                       case when t.duration_secs is null then 0 when t.duration_secs >= 86400 then 1 else t.duration_secs / 86400 end as primary_online,
                                       case when t.correct_should_secs is null then 0 when t.duration_secs >= t.correct_should_secs then 1 else t.duration_secs / t.correct_should_secs end as correct_online
                                  from x_d_d_status_log t
                                 where t.org_id in (select a.org_id from org_gradation a)
                                   and func_varchar_filter(t.contract_id,contractId) = 'true'
                                   and func_varchar_filter(t.contractor_id, contractorId) = 'true'
                                   and decode(deviceType,NULL,'true',func_funtion_filter(deviceType, t.device_type)) = 'true'
                                   and t.stat_online = '1'
                                   and t.statistics_date >= to_date(beginTime, 'yyyy-mm-dd')
                                   and t.statistics_date <=to_date(endTime, 'yyyy-mm-dd'))t,t_device_sys v where t.device_id=v.device_id)t
                                   group by rollup(t.org_code, t.org_name,t.time_stamp)
                                   having grouping_id(t.org_code, t.org_name, t.time_stamp) <= 1) 
                                   unpivot(online_rate for data_type in(correct_online as '2',primary_online as '1'));
    else --���� ������ʾ������
      open myCursor for
       with org_gradation as
         (select a.org_id,
                 a.org_code,
                 a.org_name,
                 a.level_hierarchy,
                 case when a.level_hierarchy >= 3 then substr(a.collapse_hierarchy, instr(a.collapse_hierarchy, '->', 1, 2) + 2,12) else a.org_code end display_org_code
            from (select a.org_id,
                         a.org_code,
                         a.org_name,
                         level level_hierarchy,
                         sys_connect_by_path(org_code, '->') collapse_hierarchy
                    from t_sys_org a
                   where substr(a.org_privilege_code, 0, length(orgPrivilegeCode)) = orgPrivilegeCode
                   start with a.org_code = orgCode
                  connect by prior a.org_id = a.parent_instruct_org_id) a
           order by a.org_code)
        select * from(select t.org_code, 
                         t.org_name, 
                         nvl(to_char(t.time_stamp,'yyyy-mm'),'ƽ��') as time_stamp, 
                         round(avg(primary_online),4)primary_online, 
                         round(avg(correct_online),4) correct_online from(
                         select t.device_id as org_code,v.device_name as org_name,t.statistics_month as time_stamp,t.primary_online,t.correct_online from(select t.device_id,
                                       t.org_id,
                                       t.statistics_month,
                                       t.primary_online,
                                       t.correct_online
                                  from x_d_m_status_log t
                                 where t.org_id in (select a.org_id from org_gradation a)
                                   and func_varchar_filter(t.contract_id,contractId) = 'true'
                                   and func_varchar_filter(t.contractor_id, contractorId) = 'true'
                                   and decode(deviceType,NULL,'true',func_funtion_filter(deviceType, t.device_type)) = 'true'
                                   and t.stat_online = '1'
                                   and t.statistics_month >= to_date(beginTime, 'yyyy-mm-dd')
                                   and t.statistics_month <=to_date(endTime, 'yyyy-mm-dd'))t,t_device_sys v where t.device_id=v.device_id)t
                                   group by rollup(t.org_code, t.org_name, t.time_stamp) 
                                   having grouping_id(t.org_code, t.org_name, t.time_stamp)<=1)
                                   unpivot(online_rate for data_type in(correct_online as '2',primary_online as '1'));
    END if;
  end if;
END;
/


spool off


--����������0��δ֪
insert into t_sys_code (CODE_TYPE, CODE_NO, CODE_NAME, EDITABLE, SORT_INDEX, REMARK, ENABLE_FLAG)
values ( '228', '0', 'δ֪', '1', null, null, '1');

--����������������Ͳ�Ϊ��
delete from T_FLOW_FIVE_MIN where direction_type is null;
alter table T_FLOW_FIVE_MIN modify direction_type not null;

--�޸��豸״̬��־��Ϣ��
delete from T_DEVICE_STATUS_LOG where device_id is null or start_time is null or status_type is null;
alter table T_DEVICE_STATUS_LOG modify device_id not null;
alter table T_DEVICE_STATUS_LOG modify start_time not null;
alter table T_DEVICE_STATUS_LOG modify status_type not null;


--2016/1/14 ���
--��ͨ���Ʊ�����ʵ�ʽ���ʱ��
alter table T_TRAFFIC_CONTROL ADD REAL_END_TIME DATE;
COMMENT ON COLUMN T_TRAFFIC_CONTROL.REAL_END_TIME is 'ʵ�ʽ���ʱ��';

--�޸�Υ����Υ���ص���������
update T_VIO_VIOLATION set MILEAGE=null;
alter table T_VIO_VIOLATION modify MILEAGE VARCHAR2(32);


--2016/1/18 ���
--���Ƴ�������¼�����Ƴ�������¼�����Ӻ��������ֶΡ�
alter table T_VEHTRACK_CLONE_VEHICLE add PLATE_TYPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_CLONE_VEHICLE.PLATE_TYPE is '��������';

alter table T_VEHTRACK_FAKE_VEHICLE add PLATE_TYPE VARCHAR2(2);
COMMENT ON COLUMN T_VEHTRACK_FAKE_VEHICLE.PLATE_TYPE is '��������';

--�޸���Ƶ������
alter table t_device_video add PREVIEW_PARAM varchar2(2048);
comment on column t_device_video.PREVIEW_PARAM
is '��ƵԤ����������Ҫ���ں�����Ƶ';
alter table t_device_video add PLAYBACK_PARAM varchar2(2048);
comment on column t_device_video.PLAYBACK_PARAM
is '��Ƶ�طŲ�������Ҫ���ں�����Ƶ';

--2016/1/19  �𺣲�
--�޸���Ƶ������
alter table t_device_video add CAMERA_SN varchar2(32);
comment on column t_device_video.CAMERA_SN  is '��Ƶ�Խ�ʱ�ı��';
  
  --2016/3/2 ���
  --��������ͳ�Ʒ�������˵�
  insert into T_SYS_MENU (MENU_CODE, SYS_CONFIG_ID, MENU_NAME, TARGET_URL, PARENT_CODE, SORT_INDEX, MENU_ENABLE_FLAG, REMARK, MENU_IMAGE_URL)
values ('060105', '060105', '�ڼ�����������', 'tpls/statisticsAnalysis/flowAnalysis/holidayflowAnalysis.html', '0601', '6', '1', null, 'themes/default/images/a1.png');

insert into T_SYS_FUNCTION (FUNCTION_CODE, MENU_CODE, FUNCTION_NAME, FUNCTION_FLAG, FUNCTION_DEPENDENCY, SERVICE_ID)
values ('06010501', '060105', '�ڼ�����������', '1', null, null); 

