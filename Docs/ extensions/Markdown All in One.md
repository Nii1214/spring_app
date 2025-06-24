# Markdown All in One

## 概要

Markdown All in Oneは、Visual Studio Code（VS Code）でMarkdownファイルを効率的に編集・管理するための包括的な拡張機能です。この拡張機能は、Markdownの作成からプレビュー、エクスポートまで、Markdown関連の作業を大幅に効率化します。

## 主な機能

### 1. 自動補完・スニペット
- **見出しの自動補完**: `#` を入力すると見出しレベルの候補が表示されます
- **リストの自動継続**: リスト項目を入力後、Enterキーで自動的に次の項目が作成されます
- **リンクの自動補完**: `[` を入力するとファイルやURLの候補が表示されます
- **画像の挿入**: `![` を入力すると画像ファイルの候補が表示されます

### 2. キーボードショートカット

#### Windows/Linux版
- **見出しの切り替え**: `Ctrl+Shift+]` / `Ctrl+Shift+[` で見出しレベルを変更
- **リストの切り替え**: `Ctrl+Shift+]` / `Ctrl+Shift+[` でリスト形式を変更
- **太字・斜体**: `Ctrl+B` / `Ctrl+I` でテキストを装飾
- **コードブロック**: `Ctrl+Shift+K` でコードブロックを挿入
- **プレビュー表示**: `Ctrl+Shift+V` でプレビューを開く
- **サイドバイサイド表示**: `Ctrl+K V` でエディタとプレビューを並べて表示

#### Mac版
- **見出しの切り替え**: `Cmd+Shift+]` / `Cmd+Shift+[` で見出しレベルを変更
- **リストの切り替え**: `Cmd+Shift+]` / `Cmd+Shift+[` でリスト形式を変更
- **太字・斜体**: `Cmd+B` / `Cmd+I` でテキストを装飾
- **コードブロック**: `Cmd+Shift+K` でコードブロックを挿入
- **プレビュー表示**: `Cmd+Shift+V` でプレビューを開く
- **サイドバイサイド表示**: `Cmd+K V` でエディタとプレビューを並べて表示

### 3. 自動フォーマット
- **自動リスト番号付け**: 順序付きリストの番号を自動的に管理
- **インデントの自動調整**: リストの階層構造に応じてインデントを自動調整
- **空行の自動挿入**: 見出しの前後に適切な空行を自動挿入

### 4. プレビュー機能
- **リアルタイムプレビュー**: 編集中のMarkdownをリアルタイムでプレビュー
- **サイドバイサイド表示**: エディタとプレビューを並べて表示
- **カスタムCSS**: プレビューのスタイルをカスタマイズ可能

### 5. エクスポート機能
- **HTMLエクスポート**: MarkdownをHTMLファイルに変換
- **PDFエクスポート**: MarkdownをPDFファイルに変換
- **その他の形式**: 必要に応じて他の形式にも対応

## 設定オプション

### 基本設定
```json
{
    "markdown.extension.toc.levels": "1..6",
    "markdown.extension.toc.orderedList": false,
    "markdown.extension.toc.plaintext": false,
    "markdown.extension.toc.updateOnSave": true
}
```

### プレビュー設定
```json
{
    "markdown.extension.preview.autoShowPreviewToSide": true,
    "markdown.extension.preview.breakOnSingleNewline": true,
    "markdown.extension.preview.doubleClickToSwitchToEditor": true
}
```

### 自動補完設定
```json
{
    "markdown.extension.suggest.paths": true,
    "markdown.extension.suggest.autoTrigger": true,
    "markdown.extension.suggest.include": ["**/*.md", "**/*.txt"]
}
```

## 使用方法

### 1. インストール
1. VS Codeを開く
2. 拡張機能タブ（`Cmd+Shift+X` / `Ctrl+Shift+X`）を開く
3. "Markdown All in One"を検索
4. インストールボタンをクリック

### 2. 基本的な使い方
- **新規Markdownファイル作成**: `.md`拡張子でファイルを作成
- **プレビュー表示**: `Cmd+Shift+V`（Mac） / `Ctrl+Shift+V`（Windows/Linux）でプレビューを開く
- **サイドバイサイド表示**: `Cmd+K V`（Mac） / `Ctrl+K V`（Windows/Linux）でエディタとプレビューを並べて表示

### 3. 高度な機能
- **目次生成**: `Cmd+Shift+P`（Mac） / `Ctrl+Shift+P`（Windows/Linux） → "Markdown All in One: Create Table of Contents"
- **リストの並び替え**: リスト項目を選択して `Alt+Shift+F`（全OS共通）で並び替え
- **数式の挿入**: `$` でインライン数式、`$$` でブロック数式

## OS別の違い

### Mac版の特徴
- **キーボードショートカット**: `Ctrl` の代わりに `Cmd` を使用
- **ファイルシステム**: Unix系のファイルシステム
- **ターミナル**: 内蔵ターミナルがUnix系
- **パフォーマンス**: 一般的にMac版の方が軽量で高速

### Windows版の特徴
- **キーボードショートカット**: `Ctrl` キーを使用
- **ファイルシステム**: NTFSファイルシステム
- **ターミナル**: PowerShellまたはCommand Prompt
- **統合**: Windows環境との高い統合性

### Linux版の特徴
- **キーボードショートカット**: `Ctrl` キーを使用
- **ファイルシステム**: 各種Linuxファイルシステム
- **ターミナル**: 豊富なターミナルエミュレータ
- **カスタマイズ**: 高いカスタマイズ性

## プロジェクトでの活用

### ドキュメント管理
- **設計書**: システム設計書やアーキテクチャドキュメント
- **API仕様書**: RESTful APIの仕様書やエンドポイント一覧
- **ユーザーマニュアル**: アプリケーションの使用方法やガイド

### 開発ドキュメント
- **README**: プロジェクトの概要やセットアップ手順
- **CHANGELOG**: バージョン履歴や変更内容
- **開発ガイド**: コーディング規約や開発フロー

### チーム協業
- **会議議事録**: 定例会議や設計レビューの議事録
- **タスク管理**: プロジェクトタスクの進捗管理
- **ナレッジベース**: 技術的な知見やトラブルシューティング

## ベストプラクティス

### 1. ファイル構造
```
docs/
├── README.md
├── designs/
│   ├── overview.md
│   ├── architecture.md
│   └── api-spec.md
├── guides/
│   ├── setup.md
│   ├── development.md
│   └── deployment.md
└── changelog.md
```

### 2. 命名規則
- **ファイル名**: 小文字とハイフンを使用（例: `api-specification.md`）
- **見出し**: 階層構造を明確にする（# から ###### まで）
- **リンク**: 相対パスを使用してファイル間をリンク

### 3. コンテンツ構成
- **概要**: 各ドキュメントの冒頭に概要を記載
- **目次**: 長いドキュメントには目次を自動生成
- **更新履歴**: ドキュメントの更新日時と変更内容を記録

## トラブルシューティング

### よくある問題
1. **プレビューが表示されない**
   - 拡張機能が正しくインストールされているか確認
   - VS Codeを再起動

2. **自動補完が動作しない**
   - 設定で自動補完が有効になっているか確認
   - ファイル拡張子が `.md` になっているか確認

3. **エクスポートが失敗する**
   - 必要な依存関係がインストールされているか確認
   - ファイルパスに特殊文字が含まれていないか確認

4. **Mac版特有の問題**
   - **権限エラー**: システム環境設定でVS Codeのアクセシビリティ権限を許可
   - **ショートカット競合**: 他のアプリケーションとのショートカット競合を確認

### パフォーマンス最適化
- **大きなファイル**: 1000行を超えるファイルは分割を検討
- **画像ファイル**: 適切なサイズにリサイズしてから挿入
- **リンク数**: 過度に多くのリンクがある場合は整理

## 関連拡張機能

### 推奨拡張機能
- **Markdown Preview Enhanced**: より高度なプレビュー機能
- **markdownlint**: Markdownの文法チェック
- **Paste Image**: 画像の貼り付け機能
- **Auto-Open Markdown Preview**: 自動でプレビューを開く

### 連携可能な拡張機能
- **GitLens**: Git履歴との連携
- **Draw.io Integration**: 図表の作成・編集
- **PlantUML**: UML図の作成
- **Mermaid Preview**: フローチャートの作成

## まとめ

Markdown All in Oneは、Markdownドキュメントの作成・管理を効率化する強力なツールです。自動補完、プレビュー、エクスポート機能により、開発者はドキュメント作成に集中でき、チーム全体のドキュメント品質向上に貢献します。

**Mac版では `Ctrl` の代わりに `Cmd` キーを使用する**という点が主な違いですが、機能自体は全OSで同じように動作します。この拡張機能を活用することで、プロジェクトのドキュメント管理が大幅に改善され、チーム間のコミュニケーションも円滑になります。