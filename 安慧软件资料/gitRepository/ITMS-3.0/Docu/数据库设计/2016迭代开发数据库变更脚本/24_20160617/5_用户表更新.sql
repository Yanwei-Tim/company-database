set define off
spool 24_5_�û������.log

update t_sys_user u
set u.name = (
select p.police_name from t_sys_police p where p.police_id = u.police_id
);


commit;

spool off

exit;
