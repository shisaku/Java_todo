DROP TABLE IF EXISTS todo_t CASCADE;
DROP TABLE IF EXISTS user_m CASCADE;
DROP TABLE IF EXISTS role_m CASCADE;
SET timezone = 'Asia/Tokyo';
-- ロールマスタ
CREATE TABLE role_m (
    id    INT GENERATED ALWAYS AS IDENTITY,
    name  VARCHAR(50) NOT NULL UNIQUE,
    created_at  TIMESTAMP,
    created_by  VARCHAR(40),
    updated_at  TIMESTAMP,
    updated_by  VARCHAR(40),
    PRIMARY KEY (id)
);
-- ユーザマスタ
CREATE TABLE user_m (
    user_id     VARCHAR(10)  NOT NULL,
    name        VARCHAR(40) NOT NULL,
    password    VARCHAR(20) NOT NULL,
    role_id     INT       NOT NULL,
    created_at  TIMESTAMP,
    created_by  VARCHAR(40),
    updated_at  TIMESTAMP,
    updated_by  VARCHAR(40),
    PRIMARY KEY (user_id),
    FOREIGN KEY (role_id) REFERENCES role_m(id)
);
-- TODOテーブル
CREATE TABLE todo_t (
    id          INT GENERATED ALWAYS AS IDENTITY,
    content     VARCHAR(255),
    done        BOOLEAN      NOT NULL,
    user_id     VARCHAR(10),
    created_at  TIMESTAMP,
    created_by  VARCHAR(40),
    updated_at  TIMESTAMP,
    updated_by  VARCHAR(40),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user_m(user_id)
);