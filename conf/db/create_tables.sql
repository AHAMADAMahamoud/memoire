-- Drop table

-- DROP TABLE public.app_user;

CREATE TABLE app_user (
	id serial NOT NULL,
	email varchar(255) NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	sso_id varchar(255) NOT NULL,
	CONSTRAINT app_user_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.app_user_user_profile;

CREATE TABLE app_user_user_profile (
	user_id int4 NOT NULL,
	user_profile_id int4 NOT NULL,
	CONSTRAINT app_user_user_profile_pkey PRIMARY KEY (user_id, user_profile_id),
	CONSTRAINT fk1in133uh42h13dvm6smma05we FOREIGN KEY (user_profile_id) REFERENCES user_profile(id),
	CONSTRAINT fkr3uilhvdefkptqduia9tb2m4e FOREIGN KEY (user_id) REFERENCES app_user(id)
);

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

-- Drop table

-- DROP TABLE public.fait_vente;

CREATE TABLE fait_vente (
	id serial NOT NULL,
	pkart int4 NOT NULL DEFAULT 0,
	pkcat int4 NOT NULL DEFAULT 0,
	pkgeo int4 NOT NULL DEFAULT 0,
	pktmp int4 NOT NULL DEFAULT 0,
	montantvente int4 NOT NULL DEFAULT 0,
	CONSTRAINT pk_vente PRIMARY KEY (id)
);
CREATE INDEX index_vente ON public.fait_vente USING btree (id);

-- Drop table

-- DROP TABLE public.persistent_logins;

CREATE TABLE persistent_logins (
	series varchar(255) NOT NULL,
	last_used timestamp NULL,
	"token" varchar(255) NOT NULL,
	username varchar(255) NOT NULL,
	CONSTRAINT persistent_logins_pkey PRIMARY KEY (series)
);

-- Drop table

-- DROP TABLE public.profile;

CREATE TABLE profile (
	id int8 NOT NULL,
	mpasse varchar(255) NULL,
	pseudo varchar(255) NULL,
	"role" varchar(255) NULL,
	CONSTRAINT profile_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.requette;

CREATE TABLE requette (
	id int8 NOT NULL,
	coder varchar(255) NULL,
	dateconverti timestamp NULL,
	dateexecution timestamp NULL,
	dateinsert timestamp NULL,
	etat varchar(255) NULL,
	requettefr varchar(500) NULL,
	requettesql varchar(500) NULL,
	resultat varchar(255) NULL,
	CONSTRAINT requette_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.user_profile;

CREATE TABLE user_profile (
	id serial NOT NULL,
	"type" varchar(15) NOT NULL,
	CONSTRAINT user_profile_pkey PRIMARY KEY (id)
);

-- Drop table

-- DROP TABLE public.utilisateur;

CREATE TABLE utilisateur (
	id int8 NOT NULL,
	email varchar(255) NULL,
	fonction varchar(255) NULL,
	nom varchar(255) NULL,
	prenom varchar(255) NULL,
	telephone varchar(255) NULL,
	CONSTRAINT utilisateur_pkey PRIMARY KEY (id)
);
