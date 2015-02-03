--
--    Copyright 2009-2012 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

DROP TABLE post;
DROP TABLE author;

CREATE TABLE author (
id                INT NOT NULL,
username          VARCHAR(255) NOT NULL,
password          VARCHAR(255) NOT NULL,
email             VARCHAR(255) NOT NULL,
bio               VARCHAR(255),
favourite_section VARCHAR(25),
constraint pk_author primary key (id)
);

CREATE TABLE post (
id          INT NOT NULL,
author_id   INT NOT NULL,
created_on  date NOT NULL,
section     VARCHAR(25) NOT NULL,
subject     VARCHAR(255) NOT NULL,
body        VARCHAR(255) NOT NULL,
draft       INT NOT NULL,
constraint pk_post primary key (id)
);
