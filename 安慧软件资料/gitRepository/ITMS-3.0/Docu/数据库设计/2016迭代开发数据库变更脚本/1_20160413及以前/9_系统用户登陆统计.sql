set define off
spool 9_ϵͳ�û���½ͳ��.log

create table T_SYS_OPERATE_MENU_LOG
(
  user_id      VARCHAR2(32) not null,
  menu_id      VARCHAR2(32) not null,
  men_name     VARCHAR2(100),
  operate_time DATE,
  remark       VARCHAR2(128) not null
);
comment on table T_SYS_OPERATE_MENU_LOG
  is '�û������˵���־';
comment on column T_SYS_OPERATE_MENU_LOG.user_id
  is '�û�Ψһ��ʶ';
comment on column T_SYS_OPERATE_MENU_LOG.menu_id
  is '�˵�ID';
comment on column T_SYS_OPERATE_MENU_LOG.men_name
  is '�˵�����';
comment on column T_SYS_OPERATE_MENU_LOG.operate_time
  is '����ʱ��';
comment on column T_SYS_OPERATE_MENU_LOG.remark
  is '��ע';

create table T_SYS_USER_LOGIN_LOG
(
  user_id    VARCHAR2(32) not null,
  user_ip    VARCHAR2(32),
  login_time DATE,
  remark     VARCHAR2(128) not null
)
;
comment on table T_SYS_USER_LOGIN_LOG
  is '�û���¼��־��';
comment on column T_SYS_USER_LOGIN_LOG.user_id
  is '�û�Ψһ��ʶ';
comment on column T_SYS_USER_LOGIN_LOG.user_ip
  is '��¼IP';
comment on column T_SYS_USER_LOGIN_LOG.login_time
  is '��¼ʱ��';
comment on column T_SYS_USER_LOGIN_LOG.remark
  is '��ע';

create table T_SYS_USER_STATUS
(
  user_id      VARCHAR2(32) not null,
  login_count  NUMBER(12),
  current_time DATE,
  remark       VARCHAR2(128) not null
);

comment on table T_SYS_USER_STATUS
  is '�û�״̬��';
comment on column T_SYS_USER_STATUS.user_id
  is '�û�Ψһ��ʶ';
comment on column T_SYS_USER_STATUS.login_count
  is '��¼����';
comment on column T_SYS_USER_STATUS.current_time
  is '���һ�ε�¼ʱ��';
comment on column T_SYS_USER_STATUS.remark
  is '��ע';


spool off

exit;
