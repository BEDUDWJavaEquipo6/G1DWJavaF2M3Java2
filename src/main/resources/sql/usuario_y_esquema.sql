create schema if not exists `javase2_bedu_pw`;
-- deprecated
-- grant all on javase2_bedu_pw.* to 'pwadmin'@'localhost' identified by 'ADMIN_PW_PWD';
-- ya no se puede crear y dar permisos en una linea.
-- primero se crea y luego grant o dar persmisos

create user if not exists'pwadmin'@'localhost' identified by 'ADMIN_PW_PWD';

grant all on javase2_bedu_pw.* to 'pwadmin'@'localhost';


flush privileges;