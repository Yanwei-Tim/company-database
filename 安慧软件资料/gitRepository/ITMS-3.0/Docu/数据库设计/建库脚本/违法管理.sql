/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     2015/6/15 15:46:24                           */
/*==============================================================*/


alter table T_VIO_LOCAL_PUNISH
   drop constraint FK_T_VIO_LO_RELATIONS_T_VIO_VI;

drop table T_VIO_ASSO_ACTION cascade constraints;

drop table T_VIO_EVIDENCE cascade constraints;

drop table T_VIO_FAKE_CLONE cascade constraints;

drop index "Relationship_2_FK";

drop table T_VIO_LOCAL_PUNISH cascade constraints;

drop index "Relationship_17_FK";

drop table T_VIO_OPERATION_LOG cascade constraints;

drop table T_VIO_UPLOAD_LOG cascade constraints;

drop table T_VIO_VIOLATION cascade constraints;

/*==============================================================*/
/* Table: T_VIO_ASSO_ACTION                                     */
/*==============================================================*/
create table T_VIO_ASSO_ACTION 
(
   VIO_ACTION_MATCH_ID  VARCHAR2(32)         not null,
   ROAD_TYPE            VARCHAR2(2)          default '0',
   VIOLATION_TYPE       CHAR(1),
   VIOLATION_DESC       VARCHAR2(128),
   VIOLATION_CODE       VARCHAR2(8),
   LIMIT_SPEED          numb(5),
   MAX_RATIO            number(5),
   MIN_RATIO            number(5),
   constraint PK_T_VIO_ASSO_ACTION primary key (VIO_ACTION_MATCH_ID)
);

comment on table T_VIO_ASSO_ACTION is
'Υ������ƥ���ϵ��';

comment on column T_VIO_ASSO_ACTION.VIO_ACTION_MATCH_ID is
'����Id';

comment on column T_VIO_ASSO_ACTION.VIOLATION_TYPE is
'Υ������(030)��
0����ռ��
1��������
2��������
3������
4�������
5��ѹ����
6��Υ��ͣ��
7�����䳬��
8������
9������
a��Υ��ռ��
b���ڵ�����
c������������ʻ
d��ѹ��
e��δϵ��ȫ��
';

comment on column T_VIO_ASSO_ACTION.VIOLATION_DESC is
'Υ������';

comment on column T_VIO_ASSO_ACTION.VIOLATION_CODE is
'Υ������';

comment on column T_VIO_ASSO_ACTION.LIMIT_SPEED is
'����ֵ';

comment on column T_VIO_ASSO_ACTION.MAX_RATIO is
'����ٱ�';

comment on column T_VIO_ASSO_ACTION.MIN_RATIO is
'��С���ٱ�';

/*==============================================================*/
/* Table: T_VIO_EVIDENCE                                        */
/*==============================================================*/
create table T_VIO_EVIDENCE 
(
   VIO_EVIDENCE_ID      varchar2(32)         not null,
   VIO_DEVICE_NBR       VARCHAR2(32),
   SNAP_NBR             VARCHAR2(32),
   VIO_ORG_CODE         VARCHAR2(32)         not null,
   COLLECTION_TYPE      CHAR(1)              not null,
   COLLECTION_POLICE    VARCHAR2(32),
   DISTRICT_CODE        VARCHAR2(6),
   VIO_SITE_CODE        VARCHAR2(16),
   VIOLATION_ADDRESS_DESC VARCHAR2(128),
   DIRECTION_TYPE       VARCHAR2(2),
   DIRECTION_NAME       VARCHAR2(32),
   LANE_NBR             VARCHAR2(2),
   PLATE_NBR            VARCHAR2(16),
   PLATE_TYPE           VARCHAR2(2),
   PLATE_COLOR          VARCHAR2(2),
   VIOLATION_TIME       DATE                 not null,
   VIOLATION_TYPE       CHAR(1)              not null,
   VIOLATION_CODE       VARCHAR2(8)          not null,
   VIOLATION_DESC       VARCHAR2(128),
   SPEED                NUMBER(5),
   LIMIT_LARGE          number(10),
   LIMIT_SMALL          number(10),
   LIMIT_LOWER          NUMBER(5),
   OVER_SPEED_PERCENT   NUMBER(5),
   REGIONAL_CODE        VARCHAR2(18),
   ENTRY_SITE_CODE      VARCHAR2(12),
   REGION_ENTRY_TIME    DATE,
   REGION_DISTANCE      NUMBER(10),
   RED_LIGHT_BEGIN_TIME DATE,
   RED_LIGHT_END_TIME   DATE,
   VERIFICATION         VARCHAR2(32),
   SORT_FLAG            CHAR(1)              not null,
   SORTING_BY           VARCHAR2(32),
   SORTING_TIME         CHAR(10),
   DISCARDED_REASON     CHAR(2),
   REVIEW_AUDIT_FLAG    CHAR(1)              not null,
   LOCK_FLAG            CHAR(1)              default '0' not null,
   LOCK_USER            VARCHAR2(32),
   LOCK_TIME            DATE,
   EXPORT_FLAG          CHAR(1)              default '0' not null,
   EXPORT_TIME          DATE,
   IMAGE                VARCHAR2(1024),
   VIDEO                VARCHAR2(1024),
   CREATE_TIME          DATE                 default SYSDATE not null,
   UPDATE_TIME          DATE,
   REMARK               VARCHAR2(256),
   constraint PK_T_VIO_EVIDENCE primary key (VIO_EVIDENCE_ID)
);

comment on table T_VIO_EVIDENCE is
'���ץ�ĵ�Υ��ë���ݡ�';

comment on column T_VIO_EVIDENCE.VIO_EVIDENCE_ID is
'Υ��ID';

comment on column T_VIO_EVIDENCE.VIO_DEVICE_NBR is
'�豸������';

comment on column T_VIO_EVIDENCE.SNAP_NBR is
'ץ�ı��';

comment on column T_VIO_EVIDENCE.COLLECTION_TYPE is
'1��������豸
2����·�����豸
3�������豸
4����·����
5���ƶ�����
6������ͨ
7���������
8�����Ƕ�λװ��
9�����������豸';

comment on column T_VIO_EVIDENCE.VIOLATION_ADDRESS_DESC is
'Υ���ص�';

comment on column T_VIO_EVIDENCE.DIRECTION_TYPE is
'1�����У�2�����С�';

comment on column T_VIO_EVIDENCE.PLATE_NBR is
'���ƺ���';

comment on column T_VIO_EVIDENCE.PLATE_TYPE is
'��������(002)';

comment on column T_VIO_EVIDENCE.PLATE_COLOR is
'������ɫ(003)';

comment on column T_VIO_EVIDENCE.VIOLATION_TIME is
'Υ��ʱ��';

comment on column T_VIO_EVIDENCE.VIOLATION_TYPE is
'Υ������(030)��
0����ռ��
1��������
2��������
3������
4�������
5��ѹ����
6��Υ��ͣ��
7�����䳬��
8������
9������
a��Υ��ռ��
b���ڵ�����
c������������ʻ
d��ѹ��
e��δϵ��ȫ��
';

comment on column T_VIO_EVIDENCE.VIOLATION_CODE is
'Υ������';

comment on column T_VIO_EVIDENCE.VIOLATION_DESC is
'Υ������';

comment on column T_VIO_EVIDENCE.SPEED is
'����';

comment on column T_VIO_EVIDENCE.OVER_SPEED_PERCENT is
'���ٱ�';

comment on column T_VIO_EVIDENCE.REGIONAL_CODE is
'������';

comment on column T_VIO_EVIDENCE.ENTRY_SITE_CODE is
'��ڵ�λ����';

comment on column T_VIO_EVIDENCE.REGION_ENTRY_TIME is
'�������ʱ��';

comment on column T_VIO_EVIDENCE.REGION_DISTANCE is
'�������';

comment on column T_VIO_EVIDENCE.RED_LIGHT_BEGIN_TIME is
'��ƿ�ʼʱ��';

comment on column T_VIO_EVIDENCE.RED_LIGHT_END_TIME is
'��ƽ���ʱ��';

comment on column T_VIO_EVIDENCE.VERIFICATION is
'��֤��';

comment on column T_VIO_EVIDENCE.SORT_FLAG is
'0��δ�ּ�1����Ч��¼��2��������¼;3�����ơ�����';

comment on column T_VIO_EVIDENCE.DISCARDED_REASON is
'01�����ٲ���:
02���޺���
03�����Ƴ�:
04�����޳�����Ϣ
05��������:
06��ͼƬģ��
07���೵ͼƬ:
08��һ��������
09����������:
10�����Ʋ�����
11������

';

comment on column T_VIO_EVIDENCE.REVIEW_AUDIT_FLAG is
'0��δ���ˣ�1������ͨ����2�����˲�ͨ��';

comment on column T_VIO_EVIDENCE.LOCK_FLAG is
'������ʶ
0��δ������1����������';

comment on column T_VIO_EVIDENCE.LOCK_USER is
'������';

comment on column T_VIO_EVIDENCE.LOCK_TIME is
'����ʱ��';

comment on column T_VIO_EVIDENCE.EXPORT_FLAG is
'������ʶ(040)
0��δ������1���ѵ�����';

comment on column T_VIO_EVIDENCE.EXPORT_TIME is
'����ʱ��';

comment on column T_VIO_EVIDENCE.IMAGE is
'ͼƬ�洢·��';

comment on column T_VIO_EVIDENCE.VIDEO is
'��Ƶ�洢·��';

/*==============================================================*/
/* Table: T_VIO_FAKE_CLONE                                      */
/*==============================================================*/
create table T_VIO_FAKE_CLONE 
(
   FAKE_CLONE_VIO_ID    VARCHAR2(32)         not null,
   VIO_EVIDENCE_ID      varchar2(32)         not null,
   VIO_DEVICE_NBR       VARCHAR2(32)         not null,
   SNAP_NBR             VARCHAR2(32),
   VIO_ORG_CODE         VARCHAR2(32)         not null,
   COLLECTION_TYPE      CHAR(1)              not null,
   COLLECTION_POLICE    VARCHAR2(32),
   DISTRICT_CODE        VARCHAR2(6)          not null,
   VIO_SITE_CODE        VARCHAR2(16)         not null,
   VIOLATION_ADDRESS_DESC VARCHAR2(128)        not null,
   DIRECTION_TYPE       VARCHAR2(2),
   DIRECTION_NAME       VARCHAR2(32),
   LANE_NBR             VARCHAR2(2),
   FAKE_OR_CLONE        CHAR(1)              not null,
   PLATE_NBR            VARCHAR2(16)         not null,
   PLATE_TYPE           VARCHAR2(2)          not null,
   PLATE_COLOR          VARCHAR2(2)          not null,
   VEHICLE_TYPE         VARCHAR2(3),
   VEH_CHARCTER         VARCHAR2(2),
   VEHICLE_COLOR        VARCHAR2(5),
   VEHICLE_BRAND        VARCHAR2(32),
   VIOLATION_TIME       DATE                 not null,
   VIOLATION_TYPE       CHAR(1)              not null,
   VIOLATION_CODE       VARCHAR2(8),
   VIOLATION_DESC       VARCHAR2(128)        not null,
   SPEED                NUMBER(5),
   LIMIT_LARGE          number(10),
   LIMIT_SMALL          number(10),
   LIMIT_LOWER          NUMBER(5),
   OVER_SPEED_PERCENT   NUMBER(5),
   REGIONAL_CODE        VARCHAR2(18),
   ENTRY_SITE_CODE      VARCHAR2(12),
   REGION_ENTRY_TIME    DATE,
   REGION_DISTANCE      NUMBER(10),
   RED_LIGHT_BEGIN_TIME DATE,
   RED_LIGHT_END_TIME   DATE,
   VERIFICATION         VARCHAR2(32),
   EXPORT_FLAG          CHAR(1)              default '0' not null,
   AUDIT_FLAG           CHAR(1)              not null,
   EXPORT_TIME          DATE,
   ENTRY_BY             varchar2(16),
   ENTRY_TIME           DATE,
   AUDIT_BY             varchar2(16),
   AUDIT_TIME           DATE,
   CREATE_TIME          DATE                 default SYSDATE,
   UPDATE_TIME          DATE,
   IMAGE                VARCHAR2(1024),
   VIDEO                VARCHAR2(1024),
   REMARK               VARCHAR2(256),
   constraint PK_T_VIO_FAKE_CLONE primary key (FAKE_CLONE_VIO_ID)
);

comment on table T_VIO_FAKE_CLONE is
'��¼�������Ƴ�Υ����ʵ��';

comment on column T_VIO_FAKE_CLONE.VIO_EVIDENCE_ID is
'Υ��ID';

comment on column T_VIO_FAKE_CLONE.VIO_DEVICE_NBR is
'�豸������';

comment on column T_VIO_FAKE_CLONE.SNAP_NBR is
'ץ�ı��';

comment on column T_VIO_FAKE_CLONE.COLLECTION_TYPE is
'1��������豸
2����·�����豸
3�������豸
4����·����
5���ƶ�����
6������ͨ
7���������
8�����Ƕ�λװ��
9�����������豸';

comment on column T_VIO_FAKE_CLONE.VIOLATION_ADDRESS_DESC is
'Υ���ص�';

comment on column T_VIO_FAKE_CLONE.DIRECTION_TYPE is
'1�����У�2�����С�';

comment on column T_VIO_FAKE_CLONE.FAKE_OR_CLONE is
'1�����ƣ�2�����ơ�';

comment on column T_VIO_FAKE_CLONE.PLATE_NBR is
'���ƺ���';

comment on column T_VIO_FAKE_CLONE.PLATE_TYPE is
'��������(002)';

comment on column T_VIO_FAKE_CLONE.PLATE_COLOR is
'������ɫ(003)';

comment on column T_VIO_FAKE_CLONE.VEHICLE_TYPE is
'�ο����һ��������ʹ����GA802��GA24.4��ֻ��ʶ�������������ļ�1λ������루H��K��M�ȣ���ֻ��ʶ�������͹��ļ�2λ��ȫʶ��ļ�3λ��ֻ��ʶ������������ļ�2λ���֣���һλ��0���루1���󳵣�2�����ͳ���3��С�ͳ���4��΢�ͳ�����Ħ�г�ΪM1��M2';

comment on column T_VIO_FAKE_CLONE.VEH_CHARCTER is
'GA802-2008�����ջ��鲼��ϵͳ���룺
0��δ������ϵͳ���䣩
G	����
H	����
I	����
J	�Ȼ�
K	���̾���
L	Ӫת��
M	����ת��
N	����
O	�׶�У��
P	Сѧ��У��
Q	������У��
S	��Сѧ��У��
R	Σ��Ʒ����
A	��Ӫ��
B	��·����
C	��������
D	�������
E	���ο���
F	����';

comment on column T_VIO_FAKE_CLONE.VEHICLE_COLOR is
'������ɫ(006)';

comment on column T_VIO_FAKE_CLONE.VEHICLE_BRAND is
'����Ʒ��';

comment on column T_VIO_FAKE_CLONE.VIOLATION_TIME is
'Υ��ʱ��';

comment on column T_VIO_FAKE_CLONE.VIOLATION_TYPE is
'Υ������(030)��
0����ռ��
1��������
2��������
3������
4�������
5��ѹ����
6��Υ��ͣ��
7�����䳬��
8������
9������
a��Υ��ռ��
b���ڵ�����
c������������ʻ
d��ѹ��
e��δϵ��ȫ��
';

comment on column T_VIO_FAKE_CLONE.VIOLATION_CODE is
'Υ������';

comment on column T_VIO_FAKE_CLONE.VIOLATION_DESC is
'Υ������';

comment on column T_VIO_FAKE_CLONE.SPEED is
'����';

comment on column T_VIO_FAKE_CLONE.OVER_SPEED_PERCENT is
'���ٱ�';

comment on column T_VIO_FAKE_CLONE.REGIONAL_CODE is
'������';

comment on column T_VIO_FAKE_CLONE.ENTRY_SITE_CODE is
'��ڵ�λ����';

comment on column T_VIO_FAKE_CLONE.REGION_ENTRY_TIME is
'�������ʱ��';

comment on column T_VIO_FAKE_CLONE.REGION_DISTANCE is
'�������';

comment on column T_VIO_FAKE_CLONE.RED_LIGHT_BEGIN_TIME is
'��ƿ�ʼʱ��';

comment on column T_VIO_FAKE_CLONE.RED_LIGHT_END_TIME is
'��ƽ���ʱ��';

comment on column T_VIO_FAKE_CLONE.VERIFICATION is
'��֤��';

comment on column T_VIO_FAKE_CLONE.EXPORT_FLAG is
'������ʶ(040)
0��δ������1���ѵ�����';

comment on column T_VIO_FAKE_CLONE.AUDIT_FLAG is
'0��δ��ˣ�1������ˡ�';

comment on column T_VIO_FAKE_CLONE.EXPORT_TIME is
'����ʱ��';

comment on column T_VIO_FAKE_CLONE.ENTRY_BY is
'¼����';

comment on column T_VIO_FAKE_CLONE.ENTRY_TIME is
'¼��ʱ��';

comment on column T_VIO_FAKE_CLONE.AUDIT_BY is
'�����';

comment on column T_VIO_FAKE_CLONE.IMAGE is
'ͼƬ�洢·��';

comment on column T_VIO_FAKE_CLONE.VIDEO is
'��Ƶ�洢·��';

/*==============================================================*/
/* Table: T_VIO_LOCAL_PUNISH                                    */
/*==============================================================*/
create table T_VIO_LOCAL_PUNISH 
(
   PUNISH_ID            VARCHAR2(32)         not null,
   VIO_VIOLATION_ID     VARCHAR2(32),
   DECISION_NBR         VARCHAR2(15)         not null,
   FINE_MONEY           NUMBER(5)            not null,
   FINE_SCORE           NUMBER(5)            not null,
   FINE_LATE_FEE        NUMBER(6,2)          not null,
   PAYMENT_TIME         DATE,
   AGENT_NAME           VARCHAR2(32),
   AGENT_IDENTIFICATION_TYPE CHAR(1),
   AGENT_IDENTIFICATION_NBR VARCHAR2(64),
   PROCESS_ORG          VARCHAR2(16)         not null,
   PROCESS_POLICE       VARCHAR2(32)         not null,
   PROCESS_TIME         DATE                 not null,
   REMARK               VARCHAR2(256),
   constraint PK_T_VIO_LOCAL_PUNISH primary key (PUNISH_ID)
);

comment on table T_VIO_LOCAL_PUNISH is
'���ش�����';

comment on column T_VIO_LOCAL_PUNISH.PUNISH_ID is
'����ID';

comment on column T_VIO_LOCAL_PUNISH.VIO_VIOLATION_ID is
'Υ��֤��ID';

comment on column T_VIO_LOCAL_PUNISH.DECISION_NBR is
'��������';

comment on column T_VIO_LOCAL_PUNISH.FINE_MONEY is
'�������';

comment on column T_VIO_LOCAL_PUNISH.FINE_SCORE is
'Υ���Ƿ�';

comment on column T_VIO_LOCAL_PUNISH.FINE_LATE_FEE is
'���ɽ�';

comment on column T_VIO_LOCAL_PUNISH.PAYMENT_TIME is
'����ʱ��';

comment on column T_VIO_LOCAL_PUNISH.AGENT_NAME is
'����������';

comment on column T_VIO_LOCAL_PUNISH.AGENT_IDENTIFICATION_TYPE is
'������֤������(009)';

comment on column T_VIO_LOCAL_PUNISH.AGENT_IDENTIFICATION_NBR is
'������֤������';

comment on column T_VIO_LOCAL_PUNISH.PROCESS_ORG is
'�������';

comment on column T_VIO_LOCAL_PUNISH.PROCESS_POLICE is
'������';

comment on column T_VIO_LOCAL_PUNISH.PROCESS_TIME is
'����ʱ��';

/*==============================================================*/
/* Index: "Relationship_2_FK"                                   */
/*==============================================================*/
create index "Relationship_2_FK" on T_VIO_LOCAL_PUNISH (
   VIO_VIOLATION_ID ASC
);

/*==============================================================*/
/* Table: T_VIO_OPERATION_LOG                                   */
/*==============================================================*/
create table T_VIO_OPERATION_LOG 
(
   OPE_LOG_ID           VARCHAR2(32)         not null,
   SYS_FUNCTION_CODE    VARCHAR2(32),
   OPE_USER_NAME        VARCHAR2(32)         not null,
   OPERATE_TIME         DATE                 not null,
   OPERATE_RECORD_COUNTS VARCHAR2(10)         not null,
   CONSUME_SECONDS      FLOAT                not null,
   ERROR_DESC           VARCHAR2(1024),
   COMPUTER_IP          VARCHAR2(16),
   OPERATION_RESULT     char(1),
   OPERATION_CONTENT    varchar(4096),
   VIOLATION_ID         varchar(32),
   constraint PK_T_VIO_OPERATION_LOG primary key (OPE_LOG_ID)
);

comment on table T_VIO_OPERATION_LOG is
'������־��
��¼������־��Ŀ�ģ�
��1��ϵͳ����Ա�������ϵͳӦ�õİ�ȫ�ԣ�ͨ��IP���ж���ͨ��ĳЩӦ�õ�ʹ��Ƶ���������ȣ�
��2����Ҫ�����еĲ��������Լ�¼���������ݣ������������Ƿ������µĻ�ԭ��
��3�����̼�����Ա�����������Ա������ͨ��������־��������ϵͳ���ܵĿɿ��Լ�Ч�ʡ�
';

comment on column T_VIO_OPERATION_LOG.OPE_LOG_ID is
'��־id';

comment on column T_VIO_OPERATION_LOG.SYS_FUNCTION_CODE is
'ϵͳ���ܱ���';

comment on column T_VIO_OPERATION_LOG.OPE_USER_NAME is
'�����û�';

comment on column T_VIO_OPERATION_LOG.OPERATE_TIME is
'����ʱ��';

comment on column T_VIO_OPERATION_LOG.CONSUME_SECONDS is
'������ʱ';

comment on column T_VIO_OPERATION_LOG.ERROR_DESC is
'����ʧ��ԭ��';

comment on column T_VIO_OPERATION_LOG.COMPUTER_IP is
'�û��ն�IP';

comment on column T_VIO_OPERATION_LOG.OPERATION_RESULT is
'�������:1-�ɹ���0-ʧ��';

comment on column T_VIO_OPERATION_LOG.OPERATION_CONTENT is
'�޸���Ϣ';

comment on column T_VIO_OPERATION_LOG.VIOLATION_ID is
'Υ��֤��id';

/*==============================================================*/
/* Index: "Relationship_17_FK"                                  */
/*==============================================================*/
create index "Relationship_17_FK" on T_VIO_OPERATION_LOG (
   SYS_FUNCTION_CODE ASC
);

/*==============================================================*/
/* Table: T_VIO_UPLOAD_LOG                                      */
/*==============================================================*/
create table T_VIO_UPLOAD_LOG 
(
   UPLOAD_LOG_ID        varchar2(32)         not null,
   VIO_VIOLATION_ID     VARCHAR2(32)         not null,
   UPLOAD_TIME          DATE                 not null,
   UPLOAD_RESULT        VARCHAR2(1024),
   UPLOAD_CONTENT       VARCHAR2(2048),
   UPLOAD_TYPE          CHAR(1),
   constraint PK_T_VIO_UPLOAD_LOG primary key (UPLOAD_LOG_ID)
);

comment on table T_VIO_UPLOAD_LOG is
'Υ���ϴ���־��';

comment on column T_VIO_UPLOAD_LOG.UPLOAD_LOG_ID is
'��¼ID';

comment on column T_VIO_UPLOAD_LOG.VIO_VIOLATION_ID is
'Υ��֤��ID';

comment on column T_VIO_UPLOAD_LOG.UPLOAD_TIME is
'�ϴ�ʱ��';

comment on column T_VIO_UPLOAD_LOG.UPLOAD_RESULT is
'�ϴ����';

comment on column T_VIO_UPLOAD_LOG.UPLOAD_CONTENT is
'�ϴ�����';

comment on column T_VIO_UPLOAD_LOG.UPLOAD_TYPE is
'�ϴ�����(048)';

/*==============================================================*/
/* Table: T_VIO_VIOLATION                                       */
/*==============================================================*/
create table T_VIO_VIOLATION 
(
   VIO_VIOLATION_ID     VARCHAR2(32)         not null,
   VIO_EVIDENCE_ID      varchar2(32)         not null,
   VIO_DEVICE_NBR       VARCHAR2(32)         not null,
   SNAP_NBR             VARCHAR2(32),
   VIO_ORG_CODE         VARCHAR2(32)         not null,
   COLLECTION_TYPE      CHAR(1)              not null,
   COLLECTION_POLICE    VARCHAR2(32),
   DISTRICT_CODE        VARCHAR2(6)          not null,
   VIO_SITE_CODE        VARCHAR2(16)         not null,
   VIOLATION_ADDRESS_DESC VARCHAR2(128)        not null,
   DIRECTION_TYPE       VARCHAR2(2),
   DIRECTION_NAME       VARCHAR2(32),
   LANE_NBR             VARCHAR2(2),
   PLATE_NBR            VARCHAR2(16)         not null,
   PLATE_TYPE           VARCHAR2(2)          not null,
   PLATE_COLOR          VARCHAR2(2)          not null,
   VIOLATION_TIME       DATE                 not null,
   ENFORCEMENT_CATEGORY CHAR(1)              not null,
   VIOLATION_TYPE       CHAR(1)              not null,
   VIOLATION_CODE       VARCHAR2(8)          not null,
   VIOLATION_DESC       VARCHAR2(128)        not null,
   SPEED                NUMBER(5),
   LIMIT_LARGE          number(10),
   LIMIT_SMALL          number(10),
   LIMIT_LOWER          NUMBER(5),
   OVER_SPEED_PERCENT   NUMBER(5),
   REGIONAL_CODE        VARCHAR2(18),
   ENTRY_SITE_CODE      VARCHAR2(12),
   REGION_ENTRY_TIME    DATE,
   REGION_DISTANCE      NUMBER(10),
   RED_LIGHT_BEGIN_TIME DATE,
   RED_LIGHT_END_TIME   DATE,
   VERIFICATION         VARCHAR2(32),
   VEHICLE_TYPE         VARCHAR2(3),
   VEH_CHARCTER         VARCHAR2(2),
   VEHICLE_COLOR        VARCHAR2(5),
   VEHICLE_BRAND        VARCHAR2(32),
   VEHICLE_OWNER_NAME   VARCHAR2(128),
   VEHICLE_ISSUE_ORG    VARCHAR2(16),
   VEHICLE_EXPIRE_DATE  DATE,
   VEHICLE_OWNER_ADDRESS VARCHAR2(128),
   VEHICLE_OWNER_CONTACT varchar2(64),
   VIO_STATUS           CHAR(1)              not null,
   LOCAL_PUNISH_FLAG    CHAR(1)              not null,
   EXPORT_FLAG          CHAR(1)              default '0' not null,
   EXPORT_TIME          DATE,
   ENTRY_BY             varchar2(16),
   ENTRY_TIME           DATE,
   AUDIT_BY             varchar2(16),
   AUDIT_TIME           DATE,
   UPLOAD_BY            varchar2(16),
   UPLOAD_TIME          DATE,
   CREATE_TIME          DATE                 default SYSDATE,
   UPDATE_TIME          DATE,
   IMAGE                VARCHAR2(1024),
   VIDEO                VARCHAR2(1024),
   REMARK               VARCHAR2(256),
   constraint PK_T_VIO_VIOLATION primary key (VIO_VIOLATION_ID)
);

comment on table T_VIO_VIOLATION is
'��¼Υ��������Υ�����ݡ�';

comment on column T_VIO_VIOLATION.VIO_VIOLATION_ID is
'Υ��֤��ID';

comment on column T_VIO_VIOLATION.VIO_EVIDENCE_ID is
'Υ��ID';

comment on column T_VIO_VIOLATION.VIO_DEVICE_NBR is
'�豸������';

comment on column T_VIO_VIOLATION.SNAP_NBR is
'ץ�ı��';

comment on column T_VIO_VIOLATION.COLLECTION_TYPE is
'1��������豸
2����·�����豸
3�������豸
4����·����
5���ƶ�����
6������ͨ
7���������
8�����Ƕ�λװ��
9�����������豸';

comment on column T_VIO_VIOLATION.VIOLATION_ADDRESS_DESC is
'Υ���ص�';

comment on column T_VIO_VIOLATION.DIRECTION_TYPE is
'1�����У�2�����С�';

comment on column T_VIO_VIOLATION.PLATE_NBR is
'���ƺ���';

comment on column T_VIO_VIOLATION.PLATE_TYPE is
'��������(002)';

comment on column T_VIO_VIOLATION.PLATE_COLOR is
'������ɫ(003)';

comment on column T_VIO_VIOLATION.VIOLATION_TIME is
'Υ��ʱ��';

comment on column T_VIO_VIOLATION.ENFORCEMENT_CATEGORY is
'֤������(032)��
1����ЧΥ��
2����������Υ��
3��������Υ��
4��ũ������Υ��
';

comment on column T_VIO_VIOLATION.VIOLATION_TYPE is
'Υ������(030)��
0����ռ��
1��������
2��������
3������
4�������
5��ѹ����
6��Υ��ͣ��
7�����䳬��
8������
9������
a��Υ��ռ��
b���ڵ�����
c������������ʻ
d��ѹ��
e��δϵ��ȫ��
';

comment on column T_VIO_VIOLATION.VIOLATION_CODE is
'Υ������';

comment on column T_VIO_VIOLATION.VIOLATION_DESC is
'Υ������';

comment on column T_VIO_VIOLATION.SPEED is
'����';

comment on column T_VIO_VIOLATION.OVER_SPEED_PERCENT is
'���ٱ�';

comment on column T_VIO_VIOLATION.REGIONAL_CODE is
'������';

comment on column T_VIO_VIOLATION.ENTRY_SITE_CODE is
'��ڵ�λ����';

comment on column T_VIO_VIOLATION.REGION_ENTRY_TIME is
'�������ʱ��';

comment on column T_VIO_VIOLATION.REGION_DISTANCE is
'�������';

comment on column T_VIO_VIOLATION.RED_LIGHT_BEGIN_TIME is
'��ƿ�ʼʱ��';

comment on column T_VIO_VIOLATION.RED_LIGHT_END_TIME is
'��ƽ���ʱ��';

comment on column T_VIO_VIOLATION.VERIFICATION is
'��֤��';

comment on column T_VIO_VIOLATION.VEHICLE_TYPE is
'�ο����һ��������ʹ����GA802��GA24.4��ֻ��ʶ�������������ļ�1λ������루H��K��M�ȣ���ֻ��ʶ�������͹��ļ�2λ��ȫʶ��ļ�3λ��ֻ��ʶ������������ļ�2λ���֣���һλ��0���루1���󳵣�2�����ͳ���3��С�ͳ���4��΢�ͳ�����Ħ�г�ΪM1��M2';

comment on column T_VIO_VIOLATION.VEH_CHARCTER is
'GA802-2008�����ջ��鲼��ϵͳ���룺
0��δ������ϵͳ���䣩
G	����
H	����
I	����
J	�Ȼ�
K	���̾���
L	Ӫת��
M	����ת��
N	����
O	�׶�У��
P	Сѧ��У��
Q	������У��
S	��Сѧ��У��
R	Σ��Ʒ����
A	��Ӫ��
B	��·����
C	��������
D	�������
E	���ο���
F	����';

comment on column T_VIO_VIOLATION.VEHICLE_COLOR is
'������ɫ(006)';

comment on column T_VIO_VIOLATION.VEHICLE_BRAND is
'����Ʒ��';

comment on column T_VIO_VIOLATION.VEHICLE_OWNER_NAME is
'������������';

comment on column T_VIO_VIOLATION.VEHICLE_ISSUE_ORG is
'��֤����';

comment on column T_VIO_VIOLATION.VEHICLE_EXPIRE_DATE is
'��Ч��ֹ';

comment on column T_VIO_VIOLATION.VEHICLE_OWNER_ADDRESS is
'�Ǽ�ס��';

comment on column T_VIO_VIOLATION.VEHICLE_OWNER_CONTACT is
'��ϵ��ʽ';

comment on column T_VIO_VIOLATION.VIO_STATUS is
'1����¼��
2�������
3�����ϴ�
4����֪ͨ';

comment on column T_VIO_VIOLATION.LOCAL_PUNISH_FLAG is
'0��δ������1���Ѵ�����';

comment on column T_VIO_VIOLATION.EXPORT_FLAG is
'������ʶ(040)
0��δ������1���ѵ�����';

comment on column T_VIO_VIOLATION.EXPORT_TIME is
'����ʱ��';

comment on column T_VIO_VIOLATION.ENTRY_BY is
'¼����';

comment on column T_VIO_VIOLATION.ENTRY_TIME is
'¼��ʱ��';

comment on column T_VIO_VIOLATION.AUDIT_BY is
'�����';

comment on column T_VIO_VIOLATION.UPLOAD_BY is
'�ϴ���';

comment on column T_VIO_VIOLATION.UPLOAD_TIME is
'�ϴ�ʱ��';

comment on column T_VIO_VIOLATION.IMAGE is
'ͼƬ�洢·��';

comment on column T_VIO_VIOLATION.VIDEO is
'��Ƶ�洢·��';

alter table T_VIO_LOCAL_PUNISH
   add constraint FK_T_VIO_LO_RELATIONS_T_VIO_VI foreign key (VIO_VIOLATION_ID)
      references T_VIO_VIOLATION (VIO_VIOLATION_ID);

