------------------------------------------
-- Export file for user ITMS3           --
-- Created by STJ on 2016/5/6, 14:43:45 --
------------------------------------------

set define off
spool 11_3_�����ݱ���.log


DROP TABLE T_TRUK_ACCOMPANY;
DROP TABLE T_TRUK_VIOLATION;


DROP TABLE T_VEHTRACK_CLONE_VEHICLE;
prompt
prompt Creating table T_VEHTRACK_CLONE_VEHICLE
prompt =======================================
prompt
create table T_VEHTRACK_CLONE_VEHICLE
(
  clone_vehicle_id       VARCHAR2(32) not null,
  plate_nbr              VARCHAR2(16) not null,
  plate_color            VARCHAR2(2) not null,
  vehicle_brand          VARCHAR2(32),
  vehicle_color          VARCHAR2(5),
  register_vehicle_brand VARCHAR2(64),
  register_vehicle_color VARCHAR2(32),
  device_nbr1            VARCHAR2(18) not null,
  snap_nbr1              VARCHAR2(32) not null,
  plate_color1           VARCHAR2(2),
  site_code1             VARCHAR2(16) not null,
  pass_time1             DATE not null,
  device_nbr2            VARCHAR2(18) not null,
  snap_nbr2              VARCHAR2(32) not null,
  plate_color2           VARCHAR2(2),
  pass_time2             DATE not null,
  site_code2             VARCHAR2(16) not null,
  between_distance       FLOAT,
  count_form             CHAR(1) not null,
  confirm_reason         VARCHAR2(256),
  clone_flag             CHAR(1),
  confirm_desc           VARCHAR2(256),
  confirmor              VARCHAR2(32),
  confirm_time           DATE,
  create_time            DATE default SYSDATE,
  vehicle_type           VARCHAR2(3),
  register_vehicle_type  VARCHAR2(64),
  register_plate_color   VARCHAR2(32),
  vehicle_shape          VARCHAR2(2),
  image_url1             VARCHAR2(128),
  image_url2             VARCHAR2(128),
  plate_type             VARCHAR2(2),
  org_authority_code     VARCHAR2(32)
)
;
comment on table T_VEHTRACK_CLONE_VEHICLE
  is '���Ƴ�������¼��';
comment on column T_VEHTRACK_CLONE_VEHICLE.clone_vehicle_id
  is '���Ƴ�����ID';
comment on column T_VEHTRACK_CLONE_VEHICLE.plate_nbr
  is '���ƺ���';
comment on column T_VEHTRACK_CLONE_VEHICLE.plate_color
  is '������ɫ(003)����ǰ���豸ʶ��';
comment on column T_VEHTRACK_CLONE_VEHICLE.vehicle_brand
  is '����Ʒ�ƣ���ǰ���豸ʶ��';
comment on column T_VEHTRACK_CLONE_VEHICLE.vehicle_color
  is '������ɫ(006)����ǰ���豸ʶ��';
comment on column T_VEHTRACK_CLONE_VEHICLE.register_vehicle_brand
  is '�����Ǽ�Ʒ��';
comment on column T_VEHTRACK_CLONE_VEHICLE.register_vehicle_color
  is '�����Ǽǳ�����ɫ';
comment on column T_VEHTRACK_CLONE_VEHICLE.device_nbr1
  is '�豸���1';
comment on column T_VEHTRACK_CLONE_VEHICLE.snap_nbr1
  is 'ץ�ı��1';
comment on column T_VEHTRACK_CLONE_VEHICLE.plate_color1
  is '������ɫ1';
comment on column T_VEHTRACK_CLONE_VEHICLE.site_code1
  is '������λ1';
comment on column T_VEHTRACK_CLONE_VEHICLE.pass_time1
  is '����ʱ��1';
comment on column T_VEHTRACK_CLONE_VEHICLE.device_nbr2
  is '�豸���2';
comment on column T_VEHTRACK_CLONE_VEHICLE.snap_nbr2
  is 'ץ�ı��2';
comment on column T_VEHTRACK_CLONE_VEHICLE.plate_color2
  is '������ɫ2';
comment on column T_VEHTRACK_CLONE_VEHICLE.pass_time2
  is '����ʱ��2';
comment on column T_VEHTRACK_CLONE_VEHICLE.site_code2
  is '������λ2';
comment on column T_VEHTRACK_CLONE_VEHICLE.between_distance
  is '�������';
comment on column T_VEHTRACK_CLONE_VEHICLE.count_form
  is '���Ƴ��϶���ʽ��1-������Ϣ�뱾ϵͳ�����Ǽ���Ϣ������2-������Ϣ�복�ݹ���Ϣ������3-��������¼�г�����Ϣ����ͬ��4-ֱ�߾��룻5-��λʵ�ʾ���';
comment on column T_VEHTRACK_CLONE_VEHICLE.confirm_reason
  is '�϶�����';
comment on column T_VEHTRACK_CLONE_VEHICLE.clone_flag
  is 'ȷ�ϱ�ǡ�0-δȷ�ϣ�1-��ȷ�ϣ�2-֤�ݲ��㣻3-ʶ�����';
comment on column T_VEHTRACK_CLONE_VEHICLE.confirm_desc
  is 'ȷ������';
comment on column T_VEHTRACK_CLONE_VEHICLE.confirmor
  is 'ȷ����';
comment on column T_VEHTRACK_CLONE_VEHICLE.confirm_time
  is 'ȷ��ʱ��';
comment on column T_VEHTRACK_CLONE_VEHICLE.create_time
  is '����ʱ��';
comment on column T_VEHTRACK_CLONE_VEHICLE.vehicle_type
  is '��������';
comment on column T_VEHTRACK_CLONE_VEHICLE.register_vehicle_type
  is '�����Ǽǳ�������';
comment on column T_VEHTRACK_CLONE_VEHICLE.register_plate_color
  is '�����ǼǺ�����ɫ';
comment on column T_VEHTRACK_CLONE_VEHICLE.vehicle_shape
  is '��������';
comment on column T_VEHTRACK_CLONE_VEHICLE.image_url1
  is '����ͼƬ1';
comment on column T_VEHTRACK_CLONE_VEHICLE.image_url2
  is '����ͼƬ2';
comment on column T_VEHTRACK_CLONE_VEHICLE.plate_type
  is '��������';
comment on column T_VEHTRACK_CLONE_VEHICLE.org_authority_code
  is '�������Ȩ�޴���';
alter table T_VEHTRACK_CLONE_VEHICLE
  add constraint PK_T_VEHTRACK_CLONE_VEHICLE primary key (CLONE_VEHICLE_ID);


DROP TABLE T_VEHTRACK_FAKE_CLONE;
prompt
prompt Creating table T_VEHTRACK_FAKE_CLONE
prompt ====================================
prompt
create table T_VEHTRACK_FAKE_CLONE
(
  fake_clone_vehicle_id VARCHAR2(32) not null,
  plate_nbr             VARCHAR2(16) not null,
  plate_color           VARCHAR2(2) not null,
  plate_type            VARCHAR2(2),
  vehicle_brand         VARCHAR2(32),
  vehicle_type          VARCHAR2(3),
  veh_charcter          VARCHAR2(2),
  vehicle_color         VARCHAR2(5),
  fake_or_clone         CHAR(1) not null,
  track_flag            CHAR(1),
  confirm_desc          VARCHAR2(256),
  confirmor             VARCHAR2(32),
  confirm_time          DATE,
  create_time           DATE default SYSDATE,
  is_cancelled          CHAR(1),
  vehicle_shape         VARCHAR2(2),
  org_authority_code    VARCHAR2(32)
)
;
comment on table T_VEHTRACK_FAKE_CLONE
  is '�Ѿ�ȷ�ϵļ��ơ����Ƴ�����';
comment on column T_VEHTRACK_FAKE_CLONE.fake_clone_vehicle_id
  is '������ϢID';
comment on column T_VEHTRACK_FAKE_CLONE.plate_nbr
  is '���ƺ���';
comment on column T_VEHTRACK_FAKE_CLONE.plate_color
  is '������ɫ(003)';
comment on column T_VEHTRACK_FAKE_CLONE.plate_type
  is '��������(002)';
comment on column T_VEHTRACK_FAKE_CLONE.vehicle_brand
  is '����Ʒ��';
comment on column T_VEHTRACK_FAKE_CLONE.vehicle_type
  is '�������͡��ο����һ��������ʹ����GA802��GA24.4��ֻ��ʶ�������������ļ�1λ������루H��K��M�ȣ���ֻ��ʶ�������͹��ļ�2λ��ȫʶ��ļ�3λ��ֻ��ʶ������������ļ�2λ���֣���һλ��0���루1���󳵣�2�����ͳ���3��С�ͳ���4��΢�ͳ�����Ħ�г�ΪM1��M2';
comment on column T_VEHTRACK_FAKE_CLONE.veh_charcter
  is '����ʹ�����ʡ�GA802-2008�����ջ��鲼��ϵͳ���룺
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
comment on column T_VEHTRACK_FAKE_CLONE.vehicle_color
  is '������ɫ(006)';
comment on column T_VEHTRACK_FAKE_CLONE.fake_or_clone
  is '���ƻ����ơ�1�����ƣ�2�����ơ�';
comment on column T_VEHTRACK_FAKE_CLONE.track_flag
  is '���ر��';
comment on column T_VEHTRACK_FAKE_CLONE.confirm_desc
  is 'ȷ������';
comment on column T_VEHTRACK_FAKE_CLONE.confirmor
  is 'ȷ����';
comment on column T_VEHTRACK_FAKE_CLONE.confirm_time
  is 'ȷ��ʱ��';
comment on column T_VEHTRACK_FAKE_CLONE.create_time
  is '����ʱ��';
comment on column T_VEHTRACK_FAKE_CLONE.is_cancelled
  is '�Ƿ�������Щ�������Ƴ���������ڳ������Ǽǣ���Ϊ�����ĳ����������Ƽ�¼��Ҫ�б�ǡ�
0 ������
1 ����';
comment on column T_VEHTRACK_FAKE_CLONE.vehicle_shape
  is '��������';
comment on column T_VEHTRACK_FAKE_CLONE.org_authority_code
  is '�������Ȩ�޴���';
alter table T_VEHTRACK_FAKE_CLONE
  add constraint PK_T_VEHTRACK_FAKE_CLONE primary key (FAKE_CLONE_VEHICLE_ID);


DROP TABLE T_VEHTRACK_FAKE_VEHICLE;
prompt
prompt Creating table T_VEHTRACK_FAKE_VEHICLE
prompt ======================================
prompt
create table T_VEHTRACK_FAKE_VEHICLE
(
  fake_vehicle_id    VARCHAR2(32) not null,
  plate_nbr          VARCHAR2(16) not null,
  plate_color        VARCHAR2(2) not null,
  vehicle_brand      VARCHAR2(32),
  vehicle_color      VARCHAR2(5),
  fake_flag          CHAR(1),
  confirm_reason     VARCHAR2(256),
  confirm_desc       VARCHAR2(256),
  confirmor          VARCHAR2(32),
  confirm_time       DATE,
  create_time        DATE default SYSDATE,
  device_nbr         VARCHAR2(18),
  snap_nbr           VARCHAR2(32),
  vehicle_type       VARCHAR2(16),
  vehicle_shape      VARCHAR2(2),
  plate_type         VARCHAR2(2),
  org_authority_code VARCHAR2(32)
)
;
comment on table T_VEHTRACK_FAKE_VEHICLE
  is '���Ƴ�������¼����Դ��1��Υ������¼��ʱ���˹��б�ļ��Ƴ�����2������վ���߱ȶԵļ��Ƴ���';
comment on column T_VEHTRACK_FAKE_VEHICLE.fake_vehicle_id
  is '���Ƴ�����ID';
comment on column T_VEHTRACK_FAKE_VEHICLE.plate_nbr
  is '���ƺ���';
comment on column T_VEHTRACK_FAKE_VEHICLE.plate_color
  is '������ɫ(003)';
comment on column T_VEHTRACK_FAKE_VEHICLE.vehicle_brand
  is '����Ʒ��';
comment on column T_VEHTRACK_FAKE_VEHICLE.vehicle_color
  is '������ɫ(006)';
comment on column T_VEHTRACK_FAKE_VEHICLE.fake_flag
  is '���Ʊ�ʶ';
comment on column T_VEHTRACK_FAKE_VEHICLE.confirm_reason
  is '�϶�����';
comment on column T_VEHTRACK_FAKE_VEHICLE.confirm_desc
  is 'ȷ������';
comment on column T_VEHTRACK_FAKE_VEHICLE.confirmor
  is 'ȷ����';
comment on column T_VEHTRACK_FAKE_VEHICLE.confirm_time
  is 'ȷ��ʱ��';
comment on column T_VEHTRACK_FAKE_VEHICLE.create_time
  is '����ʱ��';
comment on column T_VEHTRACK_FAKE_VEHICLE.device_nbr
  is '�豸���';
comment on column T_VEHTRACK_FAKE_VEHICLE.snap_nbr
  is 'ץ�ı��';
comment on column T_VEHTRACK_FAKE_VEHICLE.vehicle_type
  is '��������';
comment on column T_VEHTRACK_FAKE_VEHICLE.vehicle_shape
  is '��������';
comment on column T_VEHTRACK_FAKE_VEHICLE.plate_type
  is '��������';
comment on column T_VEHTRACK_FAKE_VEHICLE.org_authority_code
  is '�������Ȩ�޴���';
alter table T_VEHTRACK_FAKE_VEHICLE
  add constraint PK_T_VEHTRACK_FAKE_VEHICLE primary key (FAKE_VEHICLE_ID);


spool off

exit;
