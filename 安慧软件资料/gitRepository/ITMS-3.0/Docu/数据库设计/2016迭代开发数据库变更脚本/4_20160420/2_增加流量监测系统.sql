set define off
spool 4_2_�����������ϵͳ.log

--��������������
create table T_DEVICE_FLOW
(
  device_id               VARCHAR2(32) not null,
  related_led_id          VARCHAR2(128)
);
 
comment on table T_DEVICE_FLOW is '��������豸��';

comment on column T_DEVICE_FLOW.device_id is '���Ӽ��ϵͳID';
comment on column T_DEVICE_FLOW.related_led_id is '����LED�б�';

alter table T_DEVICE_FLOW add constraint PK_T_DEVICE_FLOW primary key (DEVICE_ID) ;
  
alter table T_DEVICE_FLOW add constraint FK_FLOW_SYS foreign key (DEVICE_ID)
  references T_DEVICE_SYS (DEVICE_ID) on delete cascade;
  
--����ϵͳ�������Ƿ�֧����������ֶ�
alter table T_DEVICE_TOLLGATE_SYS add is_flow_support CHAR(1) default 1;
comment on column T_DEVICE_TOLLGATE_SYS.is_flow_support
  is '�Ƿ�֧���������  1 ֧�� 0 ��֧��';

--Υ��ȡ֤�������Ƿ�֧����������ֶ�
alter table T_DEVICE_VIO_DEVICE add is_flow_support CHAR(1) default 1;
comment on column T_DEVICE_VIO_DEVICE.is_flow_support
  is '�Ƿ�֧���������  1 ֧�� 0 ��֧��';

spool off

exit;