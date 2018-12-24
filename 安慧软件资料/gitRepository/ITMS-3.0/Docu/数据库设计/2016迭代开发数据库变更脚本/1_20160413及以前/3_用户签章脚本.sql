set define off
spool 3_�û�ǩ�½ű�.log

create table T_SYS_USER_SIGNATURE 
(
   SIGNATURE_ID         VARCHAR2(32)         not null,
   USER_ID              VARCHAR2(32)         not null,
   SIGNATURE_INDEX      INTEGER              not null,
   SIGNATURE_IMAGE      VARCHAR2(128)        not null,
   constraint PK_T_SYS_USER_SIGNATURE primary key (SIGNATURE_ID)
);

comment on table T_SYS_USER_SIGNATURE is '�û�ǩ��ͼ���ַ';

comment on column T_SYS_USER_SIGNATURE.SIGNATURE_IMAGE is 'ǩ��ͼ���ַ';

alter table T_SYS_USER_SIGNATURE
  add constraint FK_USER_SIGNATURE foreign key (USER_ID)
  references T_SYS_USER (USER_ID) on delete cascade;
  
  
spool off

exit;