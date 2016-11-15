--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.5.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: tb_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_category (
    id integer NOT NULL,
    name character varying(50) NOT NULL,
    description character varying(100)
);


ALTER TABLE tb_category OWNER TO postgres;

--
-- Name: category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE category_id_seq OWNER TO postgres;

--
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE category_id_seq OWNED BY tb_category.id;


--
-- Name: tb_client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_client (
    id integer NOT NULL,
    name character varying(70) NOT NULL,
    date_of_birth character(10) NOT NULL,
    phone character(15),
    amount_spent double precision,
    balance double precision,
    email character varying(60)
);


ALTER TABLE tb_client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE client_id_seq OWNED BY tb_client.id;


--
-- Name: tb_employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_employee (
    id integer NOT NULL,
    name character varying(70) NOT NULL,
    date_of_birth character(10) NOT NULL,
    phone character(13) NOT NULL,
    email character varying(60),
    cpf character(14) NOT NULL,
    username character varying(15) NOT NULL,
    password character varying(10) NOT NULL,
    type character varying(20) NOT NULL,
    agency character varying(8),
    count character varying(12),
    complement character varying(10),
    number integer NOT NULL,
    city character varying(50) NOT NULL,
    street character varying(60) NOT NULL,
    district character varying(50) NOT NULL,
    state character(2) NOT NULL
);


ALTER TABLE tb_employee OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE employee_id_seq OWNER TO postgres;

--
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE employee_id_seq OWNED BY tb_employee.id;


--
-- Name: tb_expenses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_expenses (
    id integer NOT NULL,
    description character varying(100) NOT NULL,
    cost double precision NOT NULL,
    employee_id integer NOT NULL
);


ALTER TABLE tb_expenses OWNER TO postgres;

--
-- Name: expenses_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE expenses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE expenses_id_seq OWNER TO postgres;

--
-- Name: expenses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE expenses_id_seq OWNED BY tb_expenses.id;


--
-- Name: tb_goods; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_goods (
    id integer NOT NULL,
    code integer NOT NULL,
    price double precision NOT NULL,
    name character varying(50) NOT NULL,
    description character varying(100),
    size integer,
    category_id integer NOT NULL
);


ALTER TABLE tb_goods OWNER TO postgres;

--
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE produto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE produto_id_seq OWNER TO postgres;

--
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE produto_id_seq OWNED BY tb_goods.id;


--
-- Name: tb_sale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE tb_sale (
    id integer NOT NULL,
    date character(10) NOT NULL,
    observation character varying(100),
    total double precision NOT NULL,
    discount double precision NOT NULL,
    client_id integer,
    employee_id integer NOT NULL
);


ALTER TABLE tb_sale OWNER TO postgres;

--
-- Name: sale_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE sale_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sale_id_seq OWNER TO postgres;

--
-- Name: sale_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sale_id_seq OWNED BY tb_sale.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_expenses ALTER COLUMN id SET DEFAULT nextval('expenses_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_goods ALTER COLUMN id SET DEFAULT nextval('produto_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_sale ALTER COLUMN id SET DEFAULT nextval('sale_id_seq'::regclass);


--
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('category_id_seq', 1, true);


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_id_seq', 3, true);


--
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('employee_id_seq', 1, false);


--
-- Name: expenses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('expenses_id_seq', 1, false);


--
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produto_id_seq', 1, false);


--
-- Name: sale_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sale_id_seq', 1, false);


--
-- Data for Name: tb_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_category (id, name, description) FROM stdin;
1	Outros	Categoria sem definiçao ate o momento
\.


--
-- Data for Name: tb_client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_client (id, name, date_of_birth, phone, amount_spent, balance, email) FROM stdin;
2	Jose henrique	12/00/2212	(12) 00211-0020	0	0	jose.ehrneiqu@gmail.com
3		  /  /    	(  )      -    	0	0	
\.


--
-- Data for Name: tb_employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_employee (id, name, date_of_birth, phone, email, cpf, username, password, type, agency, count, complement, number, city, street, district, state) FROM stdin;
1	Marcos Henrique Alves da Silva	08111995  	83999606821  	marcos.alves@cc.ci.ufpb.br	10000974471   	alvesmarcos	quinho	Administrador	\N	\N	Apto 401	611	João Pessoa	Rua Rejane Freire Matos	Bancários	PB
\.


--
-- Data for Name: tb_expenses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_expenses (id, description, cost, employee_id) FROM stdin;
\.


--
-- Data for Name: tb_goods; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_goods (id, code, price, name, description, size, category_id) FROM stdin;
\.


--
-- Data for Name: tb_sale; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tb_sale (id, date, observation, total, discount, client_id, employee_id) FROM stdin;
\.


--
-- Name: category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- Name: client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- Name: expenses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_expenses
    ADD CONSTRAINT expenses_pkey PRIMARY KEY (id);


--
-- Name: goods_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_goods
    ADD CONSTRAINT goods_pkey PRIMARY KEY (id);


--
-- Name: sale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (id);


--
-- Name: expenses_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_expenses
    ADD CONSTRAINT expenses_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES tb_employee(id);


--
-- Name: goods_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_goods
    ADD CONSTRAINT goods_category_id_fkey FOREIGN KEY (category_id) REFERENCES tb_category(id);


--
-- Name: sale_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tb_sale
    ADD CONSTRAINT sale_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES tb_employee(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

