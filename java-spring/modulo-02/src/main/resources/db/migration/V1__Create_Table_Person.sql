-- PostgreSQL database dump
CREATE TABLE IF NOT EXISTS public.person (
    id BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(80) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    birth_date TIMESTAMP,
    address VARCHAR(100) NOT NULL,
    gender VARCHAR(6) NOT NULL
);



