--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

-- Started on 2016-11-04 14:04:07 BRT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12395)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2203 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 16393)
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE category (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    description character varying(100)
);


ALTER TABLE category OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16391)
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
-- TOC entry 2204 (class 0 OID 0)
-- Dependencies: 183
-- Name: category_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE category_id_seq OWNED BY category.id;


--
-- TOC entry 190 (class 1259 OID 16429)
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE client (
    id integer NOT NULL,
    name character varying(70) NOT NULL,
    date_of_birth character(8),
    phone character(11),
    amount_spent real,
    balance real
);


ALTER TABLE client OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16427)
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
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 189
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE client_id_seq OWNED BY client.id;


--
-- TOC entry 188 (class 1259 OID 16416)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE employee (
    id integer NOT NULL,
    name character varying(70) NOT NULL,
    data_of_birth character(8) NOT NULL,
    phone character(11) NOT NULL,
    email character varying(60),
    cpf character(11) NOT NULL,
    username character varying(15) NOT NULL,
    password character varying(10) NOT NULL,
    type character varying(20) NOT NULL,
    agency character varying(8),
    count character varying(12),
    complement character varying(10),
    number integer NOT NULL,
    city character varying(50) NOT NULL,
    street character varying(60) NOT NULL,
    neighborhood character varying(30) NOT NULL,
    fs character(2) NOT NULL
);


ALTER TABLE employee OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16414)
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
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 187
-- Name: employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE employee_id_seq OWNED BY employee.id;


--
-- TOC entry 186 (class 1259 OID 16399)
-- Name: expenses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE expenses (
    id integer NOT NULL,
    description character varying(100) NOT NULL,
    cost real NOT NULL,
    employee_id integer NOT NULL
);


ALTER TABLE expenses OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16397)
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
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 185
-- Name: expenses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE expenses_id_seq OWNED BY expenses.id;


--
-- TOC entry 182 (class 1259 OID 16387)
-- Name: goods; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE goods (
    id integer NOT NULL,
    code integer NOT NULL,
    price real NOT NULL,
    name character varying(50) NOT NULL,
    description character varying(100),
    size integer,
    category_id integer NOT NULL
);


ALTER TABLE goods OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16385)
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
-- TOC entry 2208 (class 0 OID 0)
-- Dependencies: 181
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE produto_id_seq OWNED BY goods.id;


--
-- TOC entry 192 (class 1259 OID 16441)
-- Name: sale; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE sale (
    id integer NOT NULL,
    date character(8) NOT NULL,
    observation character varying(100),
    total real NOT NULL,
    discount real NOT NULL,
    client_id integer,
    employee_id integer NOT NULL
);


ALTER TABLE sale OWNER TO postgres;

--
-- TOC entry 191 (class 1259 OID 16439)
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
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 191
-- Name: sale_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE sale_id_seq OWNED BY sale.id;


--
-- TOC entry 2050 (class 2604 OID 16396)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category ALTER COLUMN id SET DEFAULT nextval('category_id_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 16432)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- TOC entry 2052 (class 2604 OID 16419)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee ALTER COLUMN id SET DEFAULT nextval('employee_id_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 16402)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY expenses ALTER COLUMN id SET DEFAULT nextval('expenses_id_seq'::regclass);


--
-- TOC entry 2049 (class 2604 OID 16390)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY goods ALTER COLUMN id SET DEFAULT nextval('produto_id_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 16444)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale ALTER COLUMN id SET DEFAULT nextval('sale_id_seq'::regclass);


--
-- TOC entry 2187 (class 0 OID 16393)
-- Dependencies: 184
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY category (id, name, description) FROM stdin;
\.


--
-- TOC entry 2210 (class 0 OID 0)
-- Dependencies: 183
-- Name: category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('category_id_seq', 1, false);


--
-- TOC entry 2193 (class 0 OID 16429)
-- Dependencies: 190
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY client (id, name, date_of_birth, phone, amount_spent, balance) FROM stdin;
\.


--
-- TOC entry 2211 (class 0 OID 0)
-- Dependencies: 189
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_id_seq', 1, false);


--
-- TOC entry 2191 (class 0 OID 16416)
-- Dependencies: 188
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY employee (id, name, data_of_birth, phone, email, cpf, username, password, type, agency, count, complement, number, city, street, neighborhood, fs) FROM stdin;
\.


--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 187
-- Name: employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('employee_id_seq', 1, false);


--
-- TOC entry 2189 (class 0 OID 16399)
-- Dependencies: 186
-- Data for Name: expenses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY expenses (id, description, cost, employee_id) FROM stdin;
\.


--
-- TOC entry 2213 (class 0 OID 0)
-- Dependencies: 185
-- Name: expenses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('expenses_id_seq', 1, false);


--
-- TOC entry 2185 (class 0 OID 16387)
-- Dependencies: 182
-- Data for Name: goods; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY goods (id, code, price, name, description, size, category_id) FROM stdin;
\.


--
-- TOC entry 2214 (class 0 OID 0)
-- Dependencies: 181
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produto_id_seq', 1, false);


--
-- TOC entry 2195 (class 0 OID 16441)
-- Dependencies: 192
-- Data for Name: sale; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY sale (id, date, observation, total, discount, client_id, employee_id) FROM stdin;
\.


--
-- TOC entry 2215 (class 0 OID 0)
-- Dependencies: 191
-- Name: sale_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('sale_id_seq', 1, false);


--
-- TOC entry 2058 (class 2606 OID 16404)
-- Name: category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY category
    ADD CONSTRAINT category_pkey PRIMARY KEY (id);


--
-- TOC entry 2064 (class 2606 OID 16434)
-- Name: client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 16421)
-- Name: employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 16406)
-- Name: expenses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY expenses
    ADD CONSTRAINT expenses_pkey PRIMARY KEY (id);


--
-- TOC entry 2056 (class 2606 OID 16408)
-- Name: goods_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_pkey PRIMARY KEY (id);


--
-- TOC entry 2066 (class 2606 OID 16446)
-- Name: sale_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_pkey PRIMARY KEY (id);


--
-- TOC entry 2068 (class 2606 OID 16422)
-- Name: expenses_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY expenses
    ADD CONSTRAINT expenses_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- TOC entry 2067 (class 2606 OID 16409)
-- Name: goods_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_category_id_fkey FOREIGN KEY (category_id) REFERENCES category(id);


--
-- TOC entry 2069 (class 2606 OID 16447)
-- Name: sale_employee_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sale
    ADD CONSTRAINT sale_employee_id_fkey FOREIGN KEY (employee_id) REFERENCES employee(id);


--
-- TOC entry 2202 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-11-04 14:04:08 BRT

--
-- PostgreSQL database dump complete
--

