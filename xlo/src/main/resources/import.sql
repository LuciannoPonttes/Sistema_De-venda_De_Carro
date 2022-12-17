-- ROLES

INSERT INTO tb_role (ni_cod_role, vc_role) values (1, 'Administrador');
INSERT INTO tb_role (ni_cod_role, vc_role) values (2, 'Usuário');

-- CATEGORIAS

INSERT INTO tb_categoria (ni_cod_categoria, vc_desc_categoria) values (1, 'Carros e Utilitários');
INSERT INTO tb_categoria (ni_cod_categoria, vc_desc_categoria) values (2, 'Motos');
INSERT INTO tb_categoria (ni_cod_categoria, vc_desc_categoria) values (3, 'Caminhões e Micro-Ônibus');





-- TEST DATA
INSERT INTO tb_marca (NI_COD_MARCA, VC_DESC_MARCA) VALUES (1, 'GM - Chevrolet');
INSERT INTO tb_modelo (NI_COD_MODELO, VC_DESC_MODELO) VALUES (1, 'Monza Class1.8/ 2.0');