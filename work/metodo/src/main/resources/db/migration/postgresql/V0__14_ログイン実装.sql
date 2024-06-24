CREATE TABLE account (
	account_id VARCHAR(60) NOT NULL,
	password VARCHAR(255) NOT NULL,
	is_enabled BOOLEAN NOT NULL,
	create_date TIMESTAMPTZ NOT NULL,
	update_date TIMESTAMPTZ NOT NULL,
	PRIMARY KEY(account_id)
);

CREATE TABLE authorities (
	authorities_id VARCHAR(19) NOT NULL,
	account_id VARCHAR(60) NOT NULL,
	authority VARCHAR(10) NOT NULL,
	update_date TIMESTAMPTZ NOT NULL,
	PRIMARY KEY(authorities_id)
);
