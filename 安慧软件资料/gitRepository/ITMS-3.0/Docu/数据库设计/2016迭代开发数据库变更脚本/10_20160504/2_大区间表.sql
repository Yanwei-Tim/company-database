set define off
spool 10_2_�������.log

--�����������
--2016-05-04
create table T_VIO_BIG_REGION 
(
   REGIONAL_ID          VARCHAR2(32)         not null,
   REGIONAL_CODE        VARCHAR2(32)         not null,
   REGIONAL_NAME        VARCHAR2(64)         not null,
   DISTRICT_CODE        VARCHAR2(256)        not null,
   ORG_ID               VARCHAR2(32),
   ORG_PRIVILEGE_CODE   VARCHAR2(8)          not null,
   ROAD_ID              VARCHAR2(6)          not null,
   ENTRY_SITE_ID        VARCHAR2(32)         not null,
   EXIT_SITE_ID         VARCHAR2(32)         not null,
   DISTANCE             NUMBER(10,2)         not null,
   DIRECTION_TYPE       CHAR(1)              not null,
   DIRECTION_NAME       VARCHAR2(32),
   LANE_NUM             VARCHAR2(2)          not null,
   REGIONAL_DESIGN_CAPACITY VARCHAR2(32),
   LIMIT_LARGE          NUMBER(3),
   LIMIT_SMALL          NUMBER(3),
   LIMIT_OTHERS         number(10),
   LIMIT_LOWER          NUMBER(3),
   LIMIT_LARGE_MARGIN   NUMBER(5),
   LIMIT_SMALL_MARGIN   NUMBER(5),
   RELATED_VARIABLE_SPEED VARCHAR2(256),
   RELATED_LED          VARCHAR2(256),
   ENABLE_FLAG          CHAR(1),
   HISTORY_MAX_VEHICLE_NUM VARCHAR2(32),
   HISTORY_MAX_FLOW_TIME DATE,
   CREATE_BY            VARCHAR2(32),
   CREATE_TIME          DATE                 default SYSDATE,
   UPDATE_BY            VARCHAR2(32),
   REMARK               VARCHAR2(256),
   constraint PK_T_VIO_BIG_REGION primary key (REGIONAL_ID)
);

comment on table T_VIO_BIG_REGION is
'�������';

comment on column T_VIO_BIG_REGION.REGIONAL_ID is
'����ID';

comment on column T_VIO_BIG_REGION.REGIONAL_CODE is
'������';

comment on column T_VIO_BIG_REGION.REGIONAL_NAME is
'��������';

comment on column T_VIO_BIG_REGION.DISTRICT_CODE is
'���������б�(007)';

comment on column T_VIO_BIG_REGION.ORG_ID is
'����ID�����յ���������Ϊ�����û�Ҳ�����Լ�ѡ������������';

comment on column T_VIO_BIG_REGION.ORG_PRIVILEGE_CODE is
'����Ȩ�޹��˴���';

comment on column T_VIO_BIG_REGION.ROAD_ID is
'��·ID';

comment on column T_VIO_BIG_REGION.ENTRY_SITE_ID is
'���ID';

comment on column T_VIO_BIG_REGION.EXIT_SITE_ID is
'�յ�ID';

comment on column T_VIO_BIG_REGION.DISTANCE is
'������롣��λ�����';

comment on column T_VIO_BIG_REGION.DIRECTION_TYPE is
'�������ͣ�070����1�����У�2�����С�';

comment on column T_VIO_BIG_REGION.DIRECTION_NAME is
'��������';

comment on column T_VIO_BIG_REGION.LANE_NUM is
'������';

comment on column T_VIO_BIG_REGION.REGIONAL_DESIGN_CAPACITY is
'������������������������ͳ���������ó���';

comment on column T_VIO_BIG_REGION.LIMIT_LARGE is
'���޸���';

comment on column T_VIO_BIG_REGION.LIMIT_SMALL is
'С���޸���';

comment on column T_VIO_BIG_REGION.LIMIT_OTHERS is
'�������޸���';

comment on column T_VIO_BIG_REGION.LIMIT_LOWER is
'�޵���';

comment on column T_VIO_BIG_REGION.LIMIT_LARGE_MARGIN is
'����������ֵ';

comment on column T_VIO_BIG_REGION.LIMIT_SMALL_MARGIN is
'С����������ֵ';

comment on column T_VIO_BIG_REGION.RELATED_VARIABLE_SPEED is
'�����ɱ�������';

comment on column T_VIO_BIG_REGION.RELATED_LED is
'����LED�յ���';

comment on column T_VIO_BIG_REGION.ENABLE_FLAG is
'���ñ�ʶ';

comment on column T_VIO_BIG_REGION.HISTORY_MAX_VEHICLE_NUM is
'������ʷ�߷峵����';

comment on column T_VIO_BIG_REGION.HISTORY_MAX_FLOW_TIME is
'�߷�ʱ��';

comment on column T_VIO_BIG_REGION.CREATE_BY is
'������';

comment on column T_VIO_BIG_REGION.CREATE_TIME is
'����ʱ��';

comment on column T_VIO_BIG_REGION.UPDATE_BY is
'������Ա';

comment on column T_VIO_BIG_REGION.REMARK is
'��ע';

--�޸�����������
alter table T_TRAFFIC_REGION_FLOW ADD REGION_SATURATION VARCHAR2(12) ;
comment on column T_TRAFFIC_REGION_FLOW.REGION_SATURATION is '���䱥�Ͷ�';

alter table T_TRAFFIC_REGION_FLOW ADD REGION_DENSITY VARCHAR2(12) ;
comment on column T_TRAFFIC_REGION_FLOW.REGION_DENSITY is '���䳵���ܶȡ���λ������/����';



spool off

exit;