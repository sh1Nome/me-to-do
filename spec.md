# 基本仕様
## ヘッダー機能
### 画面表示
* ロゴ
* GitHubアイコン
* Xアイコン
* ログアウトボタン

#### レスポンシブ対応
* 以下を非表示
    * GitHubアイコン
    * Xアイコン
    * ログアウトボタン
* 以下を表示
    * ハンバーガーボタン

### 画面制御
* 画面上部で固定

#### レスポンシブ対応
* ハンバーガーボタンクリック時に以下をサイドバーに表示
    * GitHubアイコン
    * Xアイコン
    * ログアウトボタン

### クリック時処理
* ロゴクリックでトップ画面遷移
* GitHubアイコンクリックでGitHubの公開リポジトリに遷移（別タブ）
* XアイコンクリックでXのアカウントに遷移（別タブ）
* ログアウトボタンクリックでログアウト処理

## ログイン機能
### 画面表示
* ログイン画面
    * アカウントIDの入力項目
    * パスワードの入力項目
    * ログインボタン

#### レスポンシブ対応
* 入力項目の横にスペース

### 画面制御
* パスワードの入力値は表示・非表示を切り替え可能、初期状態は非表示
* メッセージ/エラーメッセージは削除可能

### ログイン処理
* ログインボタンクリックでログイン処理
* アカウントIDとパスワードで認証処理
* ログインに失敗した場合、ログイン画面に遷移しエラーメッセージを表示
* ログインに成功した場合、トップ画面に遷移
* ログアウトに成功した場合、ログイン画面に遷移しメッセージを表示
* パスワードをハッシュ化

## アカウント作成機能
### 画面表示
* ログイン画面
    * 「アカウント作成はこちら」リンク
* アカウント作成画面
    * アカウントIDの入力項目
    * パスワードの入力項目
    * アカウント作成ボタン

#### レスポンシブ対応
* 入力項目の横にスペース

### 画面制御
* 入力チェック
    * アカウントID
        * 60文字以内
    * パスワード

### アカウント追加処理
* データベース登録仕様に従いデータベースを更新
* 登録成功
    * ログイン画面へ遷移する
    * メッセージを表示する
* 登録失敗
    * ログイン画面へ遷移する
    * エラーメッセージを表示する

#### データベース登録仕様
|テーブル|カラム|値|
|:-:|:-:|:-:|
|account|account_id|アカウントIDの入力値|
||password|パスワードの入力値をハッシュ化|
||is_enabled|true|
||create_date|登録日時|
||update_date|登録日時|
|authorities|authorities_id|ATyyyyMMddHHmmssSSS|
||account_id|アカウントIDの入力値|
||authority|ROLE_USER|
||update_date|登録日時|

## レスポンシブ対応
* ブレークポイント960px
* ブレークポイント以上でPC向け表示に切り替え
* ブレークポイント未満でモバイル向け表示に切り替え

# データベース仕様
## account
|カラム名|データ型|NOT NULL|主キー|
|:-:|:-:|:-:|:-:|
|account_id|VARCHAR(60)|〇|〇|
|password|VARCHAR(255)|〇||
|is_enabled|BOOLEAN|〇||
|create_date|TIMESTAMPTZ|〇||
|update_date|TIMESTAMPTZ|〇||

## authorities
|カラム名|データ型|NOT NULL|主キー|
|:-:|:-:|:-:|:-:|
|authorities_id|VARCHAR(19)|〇|〇|
|account_id|VARCHAR(60)|〇||
|authority|VARCHAR(10)|〇||
|update_date|TIMESTAMPTZ|〇||

# 技術仕様
* Docker
* flyway
* Gradle
* lombok
* PostgreSQL
* Spring Boot 3.3.0
* Spring Data JPA
* Spring Security
* thymeleaf
* UIkit
* VSCode
* Vue.js