set define off
spool 10_�̶�����ϵͳ�������Ƶ���.log

update T_SYS_CODE c set c.code_name = '�̶������' where c.code_type = '400' and c.code_no = '04';
commit;


spool off

exit;