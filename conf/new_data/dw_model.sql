-- Drop table

-- DROP TABLE public.dim_article;

CREATE TABLE dim_article (
	id serial NOT NULL,
	codeart varchar(255) NULL,
	designationart varchar(255) NULL,
	prixvente int4 NOT NULL DEFAULT 0,
	CONSTRAINT pk_article PRIMARY KEY (id)
);
CREATE INDEX index_article ON public.dim_article USING btree (id);

-- Drop table

-- DROP TABLE public.dim_categorie;

CREATE TABLE dim_categorie (
	id serial NOT NULL,
	codecat varchar(255) NULL,
	descriptioncat varchar(255) NULL,
	nomcat varchar(255) NULL,
	CONSTRAINT pk_categorie PRIMARY KEY (id)
);
CREATE INDEX index_categorie ON public.dim_categorie USING btree (id);

-- Drop table

-- DROP TABLE public.dim_geographie;

CREATE TABLE dim_geographie (
	id serial NOT NULL,
	codegeo varchar(25) NULL,
	ilegeo varchar(255) NULL,
	villegeo varchar(255) NULL,
	CONSTRAINT pk_geographie PRIMARY KEY (id)
);
CREATE INDEX index_geographie ON public.dim_geographie USING btree (id);

-- Drop table

-- DROP TABLE public.dim_temps;

CREATE TABLE dim_temps (
	id int4 NOT NULL DEFAULT 0,
	anneetmp int4 NULL,
	datetmp timestamp NULL,
	journomtmp varchar(255) NULL,
	jourtmp int4 NOT NULL DEFAULT 0,
	moisnomtmp varchar(255) NULL,
	moistmp int4 NOT NULL DEFAULT 0,
	semestretmp int4 NULL,
	trimestretmp int4 NULL,
	CONSTRAINT pk_temps PRIMARY KEY (id)
);
CREATE INDEX index_temps ON public.dim_temps USING btree (id);



CREATE TABLE fait_vente (
	id serial NOT NULL,
	pkart int4 NOT NULL DEFAULT 0,
	pkcat int4 NOT NULL DEFAULT 0,
	pkgeo int4 NOT NULL DEFAULT 0,
	pktmp int4 NOT NULL DEFAULT 0,
	qtevente int4 NOT NULL DEFAULT 0,
	montantvente int4 NOT NULL DEFAULT 0,
	CONSTRAINT pk_vente PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.requette;

CREATE TABLE requete (
	id serial NOT NULL,
	code_req varchar(255) NULL,
	date_converti timestamp NULL,
	date_execution timestamp NULL,
	date_insert timestamp NULL,
	etat_req varchar(255) NULL,
	requette_fr varchar(500) NULL,
	requette_sql varchar(500) NULL,
	resultat json  NULL,
	CONSTRAINT requette_pkey PRIMARY KEY (id)
);
