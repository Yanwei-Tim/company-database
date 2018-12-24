set define off
spool 8_2_������־����.log

drop  table T_SYS_OPERATE_MENU_LOG;
create table T_SYS_OPERATE_MENU_LOG
(
  USER_ID      VARCHAR2(32) not null,
  MENU_ID      VARCHAR2(32) not null,
  MEN_NAME     VARCHAR2(100),
  OPERATE_TIME DATE,
  REMARK       VARCHAR2(128) not null,
  ORG_ID       VARCHAR2(32) not null,
  OPER_IP      VARCHAR2(60)
);

-- Add comments to the table 
comment on table T_SYS_OPERATE_MENU_LOG
  is '�û������˵���־';
-- Add comments to the columns 
comment on column T_SYS_OPERATE_MENU_LOG.USER_ID
  is '�û�Ψһ��ʶ';
comment on column T_SYS_OPERATE_MENU_LOG.MENU_ID
  is '�˵�ID';
comment on column T_SYS_OPERATE_MENU_LOG.MEN_NAME
  is '�˵�����';
comment on column T_SYS_OPERATE_MENU_LOG.OPERATE_TIME
  is '����ʱ��';
comment on column T_SYS_OPERATE_MENU_LOG.REMARK
  is '��ע';
comment on column T_SYS_OPERATE_MENU_LOG.ORG_ID
  is '����';
comment on column T_SYS_OPERATE_MENU_LOG.OPER_IP
  is '������IP';

spool off

exit;