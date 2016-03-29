﻿conn system/oracle


grant create view to eureka;


connect eureka/admin




create or replace
view v_cliente
as
select
chr_cliecodigo    codigo,
vch_cliepaterno   paterno,
vch_cliematerno   materno,
vch_clienombre    nombre,
chr_cliedni       dni,
vch_clieciudad    ciudad,
vch_cliedireccion direccion,
vch_clietelefono  telefono,
vch_clieemail     email
from cliente;


select 
codigo, paterno, materno, nombre, 
dni, ciudad, direccion, telefono, email
from v_cliente;


