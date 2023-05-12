CREATE TABLE IF NOT EXISTS "сотрудник_компании" (
id BIGINT PRIMARY KEY,
"фамилия" VARCHAR(255),
"имя" VARCHAR(255),
"отчество" VARCHAR(255),
"должность" VARCHAR(255),
"дата_рождения" VARCHAR(255),
"адрес" VARCHAR(255),
"сотовый_телефон" VARCHAR(255),
"электронный_адрес" VARCHAR(255),
"логин" VARCHAR(255),
"пароль" VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS "кассовый_чек" (
id BIGINT PRIMARY KEY,
"дата_покупки" VARCHAR(255),
"продавец" BIGINT,
 FOREIGN KEY ("продавец")  REFERENCES "сотрудник_компании" (id)
);


CREATE TABLE IF NOT EXISTS "поставщик" (
id BIGINT PRIMARY KEY,
"название" VARCHAR(255),
"сотрудник_для_связи" BIGINT,
"адрес" VARCHAR(255),
"телефон" VARCHAR(255),
"факс" VARCHAR(255),
"электронный_адрес" VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS "сотрудник_поставщика" (
id BIGINT PRIMARY KEY,
"фамилия" VARCHAR(255),
"имя" VARCHAR(255),
"отчество" VARCHAR(255),
"должность" VARCHAR(255),
"дата_рождения" VARCHAR(255),
"адрес" VARCHAR(255),
"сотовый_телефон" VARCHAR(255),
"электронный_адрес" VARCHAR(255),
"компания_поставщика" BIGINT,
 FOREIGN KEY ("компания_поставщика")  REFERENCES "поставщик" (id)
);

CREATE TABLE IF NOT EXISTS "склад"  (
id BIGINT PRIMARY KEY,
"название" VARCHAR(255),
"адрес" VARCHAR(255),
"складской_телефон" VARCHAR(255),
"площадь" VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS "сотрудник_склад" (
  id BIGINT PRIMARY KEY,
  worker_id BIGINT REFERENCES "сотрудник_компании",
  warehouse_id BIGINT REFERENCES "склад",
  "начальная_дата_работы_на_складе" VARCHAR(255),
  "конечная_дата_работы_на_складе" VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS "сектор"  (
id BIGINT PRIMARY KEY,
"название" VARCHAR(255),
"описание_местоположения" VARCHAR(255),
"склад" BIGINT,
 FOREIGN KEY ("склад")  REFERENCES "склад" (id)
);

CREATE TABLE IF NOT EXISTS "стеллаж"  (
id BIGINT PRIMARY KEY,
"название" VARCHAR(255),
"описание_местоположения" VARCHAR(255),
"сектор" BIGINT,
 FOREIGN KEY ("сектор")  REFERENCES "сектор" (id)
);


CREATE TABLE IF NOT EXISTS "раздел_рти"  (
id BIGINT PRIMARY KEY,
"название" VARCHAR(255),
"описание" VARCHAR(255)
);


CREATE TABLE IF NOT EXISTS "тип_товара" (
id BIGINT PRIMARY KEY,
"название" VARCHAR(255),
"описание" VARCHAR(255),
"раздел_рти" BIGINT,
 FOREIGN KEY ("раздел_рти")  REFERENCES "раздел_рти" (id)
);

CREATE TABLE IF NOT EXISTS "партия" (
id BIGINT PRIMARY KEY,
"номер_партии" VARCHAR(255),
"поставщик" BIGINT,
"количество" DECIMAL,

 FOREIGN KEY ("поставщик")  REFERENCES "поставщик" (id)
);

CREATE TABLE IF NOT EXISTS "товар" (
id BIGINT PRIMARY KEY,
"название" VARCHAR(255),
"тип_товара" BIGINT,
"описание " VARCHAR(255),
"расположение" BIGINT,
"id_партии" BIGINT,
"остаток_организации" DECIMAL,
"единица_измерения" VARCHAR(255),
"цена" DECIMAL,
"дата_прихода" VARCHAR(255),

 FOREIGN KEY ("id_партии")  REFERENCES "партия" (id),
 FOREIGN KEY ("тип_товара")  REFERENCES "тип_товара" (id),
 FOREIGN KEY ("расположение")  REFERENCES "стеллаж" (id)
);

CREATE TABLE IF NOT EXISTS "чек_товар" (
  id BIGINT PRIMARY KEY,
  receipt_id BIGINT REFERENCES "кассовый_чек",
  product_id BIGINT REFERENCES "товар",
  "количество" DECIMAL
);


