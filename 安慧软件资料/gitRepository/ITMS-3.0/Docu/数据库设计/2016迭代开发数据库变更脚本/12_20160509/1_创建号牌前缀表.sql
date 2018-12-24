set define off
spool 12_1_��������ǰ׺��.log

--2016/05/09
--��������ǰ׺��
create table T_SYS_PLATE_PREFIX 
(
   PLATE_PREFIX         VARCHAR2(32)         not null,
   ORG_CODE             VARCHAR2(32)         not null,
   constraint PK_T_SYS_PLATE_PREFIX primary key (PLATE_PREFIX)
);

comment on table T_SYS_PLATE_PREFIX is '����ǰ׺��';

--��������ʡ����ǰ׺����
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��A', '530100000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��B', '530100000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��C', '530600000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��D', '530300000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��E', '532300000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��F', '530400000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��G', '532500000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��H', '532600000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��J', '530800000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��L', '532900000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��K', '532800000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��M', '530500000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��N', '533100000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��P', '530700000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��Q', '533300000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��R', '533400000000');
insert into T_SYS_PLATE_PREFIX (PLATE_PREFIX, ORG_CODE)
values ( '��S', '530900000000');
commit;


spool off

exit;
