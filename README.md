# 概要
ToDoアプリケーション、作成途中  
数多くの子タスクを作れて、カンバン表示にできたりリスト表示にできたりするやつを作りたい。  
5段階くらいの階層構造にできたらいいなと思っている  

# 開発環境構築
## コンテナ開発
1. [spring-boot-dev-containers](https://github.com/sh1Nome/spring-boot-dev-containers/tree/main)参照

## ローカル開発
1. このリポジトリをクローンする
1. `data`と`jdk`ディレクトリを作成する
    * `data`: `docker-compose`で起動するPostgresにマウントするデータディレクトリ
    * `jdk`: 開発に使うJDKの配置場所
1. `jdk`リポジトリに[Eclipse Temurin JDK17](https://adoptium.net/temurin/releases/?os=windows&arch=x64&package=jdk&version=17)を配置する
1. `work/metodo`をVSCodeで開き以下のワークスペース設定をする
    * `java.jdt.ls.java.home"`: Java拡張機能
    * `"spring-boot.ls.java.home"`: Spring Boot拡張機能
