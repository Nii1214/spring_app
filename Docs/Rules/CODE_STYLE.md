# コーディング規約

このドキュメントは、SpringBoot, Thymeleaf, jQuery を使用したWebアプリケーション開発におけるコーディング規約を定めるものです。
プロジェクトに参加するすべての開発者は、この規約を遵守してください。

## 1. 全般的な規約

### 1.1. 命名規則

- **原則**: Javaの標準的な命名規則に従います。
  - **クラス名**: `UpperCamelCase` (例: `UserController`, `ItemService`)
  - **メソッド名**: `lowerCamelCase` (例: `getUser`, `calculatePrice`)
  - **変数名**: `lowerCamelCase` (例: `userName`, `totalAmount`)
  - **定数名**: `UPPER_SNAKE_CASE` (例: `MAX_SIZE`, `DEFAULT_NAME`)

### 1.2. フォーマット

- **インデント**: 半角スペース4つを使用します。タブは使用しません。
- **1行の長さ**: 原則として120文字以内とします。
- **括弧**: `if`, `for`, `while` などの制御構文では、処理が1行であっても必ず波括弧 `{}` を使用します。
- **改行**: メソッド呼び出しが長くなる場合は、引数の前で改行します。

### 1.3. コメント

- **JavaDoc**: `public` なクラスとメソッドには、原則としてJavaDocコメントを記述します。
- **コメント**: 複雑なロジックや、意図が分かりにくいコードにはコメントを追加します。ただし、コード自体で意図が明確に伝わるように記述することを優先します。

### 1.4. 言語

- **ソースコード**: クラス名、メソッド名、変数名などの識別子は原則として英語を使用します。
- **コメント**: 日本語で記述します。
- **UI**: 画面に表示する文言は日本語とします。

## 2. Java (Spring Boot)

### 2.1. パッケージ構成

- 機能単位でパッケージを分割することを基本とします。
  ```
  com.example.app
  ├── config         // 設定クラス
  ├── controller     // Controllerクラス
  ├── service        // Serviceクラス
  ├── repository     // Repositoryクラス
  ├── entity         // Entityクラス
  ├── dto            // DTOクラス
  └── exception      // 例外クラス
  ```

### 2.2. レイヤーごとの責務

- **Controller**:
  - HTTPリクエストの受付とレスポンスの返却に専念します。
  - ビジネスロジックは含めず、Service層を呼び出します。
  - リクエストパラメータのバリデーションを行います。
- **Service**:
  - ビジネスロジックを実装します。
  - トランザクション管理はService層で行います。
  - 必要に応じて他のServiceやRepositoryを呼び出します。
- **Repository**:
  - データアクセス（DB操作）に専念します。
  - Spring Data JPA を利用し、インターフェースとして定義します。

### 2.3. DTO (Data Transfer Object)

- ControllerとViewの間、またはService層をまたがるデータの受け渡しには、DTOを使用します。
- Entityを直接ControllerやViewに渡さないでください。これにより、ドメインモデルとプレゼンテーション層が疎結合になります。

### 2.4. 例外処理

- 業務エラーが発生した場合は、独自の例外クラス（`RuntimeException`を継承）を作成してスローします。
- `@ControllerAdvice` を使用して、例外を横断的にハンドリングします。

### 2.5. Lombok

- Lombokの使用を推奨します。
- `@Data` の使用は注意深く行い、意図しないセッターや `toString()` のオーバーライドを避けるため、必要に応じて `@Getter`, `@Setter`, `@ToString` などを個別に指定します。

## 3. Thymeleaf

### 3.1. `th:` 属性の利用

- HTMLタグの属性として `th:` 属性を積極的に利用します。
- `th:text` や `th:utext` を使い分け、XSS脆弱性を防止します。原則として `th:text` を使用してください。

### 3.2. インラインスクリプト

- Thymeleafテンプレート内にJavaScriptを記述するインラインスクリプトは原則禁止します。
- JavaScriptは静的リソース（`.js`ファイル）として分離し、`th:src` で読み込みます。
- どうしてもインラインスクリプトが必要な場合は、`[[...]]` や `[(...)]` を使用します。

### 3.3. フラグメント

- ヘッダー、フッター、サイドバーなど、共通のUI部品はフラグメント (`th:fragment`) として定義し、`th:insert` または `th:replace` で再利用します。

### 3.4. URLの記述

- リンクやリソースのURLは、`@{...}` 構文を使用して記述します。これにより、コンテキストパスが自動的に付与されます。

## 4. JavaScript (jQuery)

### 4.1. スコープ

- グローバルスコープの汚染を防ぐため、コード全体を即時実行関数で囲みます。
  ```javascript
  (function($) {
    // Your code here
  })(jQuery);
  ```

### 4.2. イベントハンドラ

- イベントハンドラは `.on()` メソッドを使用して登録します。
  ```javascript
  // Good
  $('#myButton').on('click', function() { /* ... */ });

  // Bad
  $('#myButton').click(function() { /* ... */ });
  ```

### 4.3. DOM操作

- 同じ要素を複数回操作する場合は、セレクタの結果を変数にキャッシュしてパフォーマンスを向上させます。
  ```javascript
  // Good
  var $myElement = $('#myElement');
  $myElement.addClass('active');
  $myElement.text('Hello');

  // Bad
  $('#myElement').addClass('active');
  $('#myElement').text('Hello');
  ```
- 変数名の先頭には `$` をつけ、jQueryオブジェクトであることを明示します。

### 4.4. Ajax

- Spring Boot側のAPIと連携する際は、`$.ajax()` を使用します。
- `done()`, `fail()`, `always()` を使用して、非同期処理を記述します。

## 5. HTML/CSS

### 5.1. 命名規則

- CSSのクラス名は、BEM (Block, Element, Modifier) などの命名規則に従い、予測可能で再利用しやすいものにします。
  ```html
  <div class="card">
    <h2 class="card__title">...</h2>
    <p class="card__description--small">...</p>
  </div>
  ```

### 5.2. インラインスタイル

- `style`属性によるインラインスタイルは原則禁止します。
- スタイルはすべて外部CSSファイルに記述します。

## 6. その他

### 6.1. Gitコミットメッセージ

- コミットメッセージは、以下の形式で記述します。
  ```
  <type>(<scope>): <subject>
  ```
  - **type**: `feat`, `fix`, `docs`, `style`, `refactor`, `test`, `chore` など
  - **scope**: 変更の範囲 (例: `user`, `item`, `auth`)
  - **subject**: 変更内容の簡潔な説明
- 本文には、変更の理由や詳細を記述します。

