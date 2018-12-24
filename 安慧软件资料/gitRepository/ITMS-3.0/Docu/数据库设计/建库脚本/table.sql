-- Create table
create table T_SYS_ASSO_USER_DESK
(
  asso_id     VARCHAR2(32) not null,
  id          VARCHAR2(32),
  user_id     VARCHAR2(32),
  customer_id VARCHAR2(32),
  desk_id     VARCHAR2(32)
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table T_SYS_ASSO_USER_DESK
  is '�û�����̨��ϵ��';
-- Add comments to the columns 
comment on column T_SYS_ASSO_USER_DESK.asso_id
  is '��ϵID';
comment on column T_SYS_ASSO_USER_DESK.id
  is 'id';
comment on column T_SYS_ASSO_USER_DESK.user_id
  is '�û�id';
comment on column T_SYS_ASSO_USER_DESK.customer_id
  is '�ͻ�id';
comment on column T_SYS_ASSO_USER_DESK.desk_id
  is '����̨id';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_ASSO_USER_DESK
  add constraint PK_T_SYS_ASSO_USER_DESK primary key (ASSO_ID)
  using index 
  tablespace ITMS_DATA
  pctfree 10
  initrans 2
  maxtrans 255;


-- Create table
create table T_SYS_ASSO_USER_ROLE
(
  asso_id VARCHAR2(32) not null,
  role_id VARCHAR2(32) not null,
  user_id VARCHAR2(32) not null
)
tablespace ITMS_DATA
  pctfree 10
  initrans 1
  maxtrans 255;
-- Add comments to the table 
comment on table T_SYS_ASSO_USER_ROLE
  is '�û���ɫ��ϵ��';
-- Add comments to the columns 
comment on column T_SYS_ASSO_USER_ROLE.asso_id
  is '��ϵID';
comment on column T_SYS_ASSO_USER_ROLE.role_id
  is '��ɫID';
comment on column T_SYS_ASSO_USER_ROLE.user_id
  is '�û�ID';
-- Create/Recreate primary, unique and foreign key constraints 
alter table T_SYS_ASSO_USER_ROLE
  add constraint PK_T_ASSO_USER_ROLE primary key (ASSO_ID)
  using index 
  tablespace ITMS_DATA
  pctfree 10
  initrans 2
  maxtrans 255;

