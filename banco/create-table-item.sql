CREATE TABLE item (
    codigo serial NOT NULL,
    descricao character varying(100) NOT NULL,
    valor numeric(18,2) NOT NULL,
    observacao text DEFAULT NULL,
    CONSTRAINT item_pk PRIMARY KEY (codigo)
);

CREATE TABLE pedido (
    codigo serial NOT NULL,
    cliente character(100) NOT NULL,
    data date NOT NULL,
    telefone character(15),
    status character(10),
    valor_total numeric(18,2) NOT NULL,
    CONSTRAINT pedido_pk PRIMARY KEY (codigo)
);

CREATE TABLE itens_pedido (
    codigo serial NOT NULL,
    codigo_pedido integer NOT NULL,
    codigo_item integer NOT NULL,
    valor numeric(18,2) NOT NULL,
    quantidade integer NOT NULL,
    valor_total numeric(18,2) NOT NULL,
    CONSTRAINT itens_pedido_pk PRIMARY KEY (codigo),
    CONSTRAINT ip_pedido FOREIGN KEY (codigo_pedido) REFERENCES pedido (codigo),
    CONSTRAINT ip_item FOREIGN KEY (codigo_item) REFERENCES item (codigo)
);