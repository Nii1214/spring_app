# 役割

優秀な UI/UX デザイナー

# 背景

プログラミング学習サイト兼プログラマー向け便利機能アプリ「デベリオ」のデザインテーマを決めます。
主なユーザーはプログラミング初心者から中級者で、学習サイト、ToDo、ノート、タスク管理等の機能を持ち合わせています。


# 命令
Apple のデザインルールがあります。

- https://developer.apple.com/design/human-interface-guidelines
- https://developer.apple.com/design

tailwind.cssを使用してデザインルールをを作成してください。
tailwind.cssで実装できないものに関してはカスタムcssで対応してください。

# デザインルール

## 1. カラーパレット

### プライマリカラー
- **メインカラー**: `#007AFF` (Apple Blue)
- **セカンダリカラー**: `#5856D6` (Apple Purple)
- **アクセントカラー**: `#FF3B30` (Apple Red)

### ニュートラルカラー
- **背景色**: `#F2F2F7` (System Gray 6)
- **カード背景**: `#FFFFFF`
- **テキスト**: `#1D1D1F` (Primary Text)
- **セカンダリテキスト**: `#86868B` (Secondary Text)
- **ボーダー**: `#C7C7CC` (System Gray 4)

### セマンティックカラー
- **成功**: `#34C759` (Apple Green)
- **警告**: `#FF9500` (Apple Orange)
- **エラー**: `#FF3B30` (Apple Red)
- **情報**: `#007AFF` (Apple Blue)

## 2. タイポグラフィ

### フォントファミリー
```css
font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
```

### フォントサイズ
- **H1**: `text-4xl font-bold` (32px)
- **H2**: `text-3xl font-semibold` (24px)
- **H3**: `text-2xl font-semibold` (20px)
- **H4**: `text-xl font-medium` (18px)
- **Body**: `text-base` (16px)
- **Small**: `text-sm` (14px)
- **Caption**: `text-xs` (12px)

### フォントウェイト
- **Light**: `font-light` (300)
- **Regular**: `font-normal` (400)
- **Medium**: `font-medium` (500)
- **Semibold**: `font-semibold` (600)
- **Bold**: `font-bold` (700)

## 3. スペーシング

### 基本単位
- **4px** を基本単位として使用
- **xs**: `space-1` (4px)
- **sm**: `space-2` (8px)
- **md**: `space-4` (16px)
- **lg**: `space-6` (24px)
- **xl**: `space-8` (32px)
- **2xl**: `space-12` (48px)

### パディング
- **コンテナ**: `p-6` (24px)
- **カード**: `p-4` (16px)
- **ボタン**: `px-4 py-2` (16px × 8px)
- **入力フィールド**: `px-3 py-2` (12px × 8px)

### マージン
- **セクション間**: `mb-8` (32px)
- **要素間**: `mb-4` (16px)
- **グループ内**: `mb-2` (8px)

## 4. ボーダーとシャドウ

### ボーダー
- **半径**: `rounded-lg` (8px)
- **太さ**: `border` (1px)
- **色**: `border-gray-200`

### シャドウ
- **カード**: `shadow-sm` (軽いシャドウ)
- **モーダル**: `shadow-lg` (強いシャドウ)
- **ホバー**: `hover:shadow-md` (中程度のシャドウ)

## 5. コンポーネントデザイン

### ボタン
```css
/* プライマリボタン */
.btn-primary {
  @apply bg-blue-500 hover:bg-blue-600 text-white font-medium px-4 py-2 rounded-lg transition-colors duration-200;
}

/* セカンダリボタン */
.btn-secondary {
  @apply bg-gray-100 hover:bg-gray-200 text-gray-900 font-medium px-4 py-2 rounded-lg transition-colors duration-200;
}

/* アウトラインボタン */
.btn-outline {
  @apply border border-blue-500 text-blue-500 hover:bg-blue-50 font-medium px-4 py-2 rounded-lg transition-colors duration-200;
}
```

### カード
```css
.card {
  @apply bg-white rounded-lg shadow-sm border border-gray-200 p-4;
}

.card-hover {
  @apply card hover:shadow-md transition-shadow duration-200;
}
```

### 入力フィールド
```css
.input {
  @apply w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent transition-colors duration-200;
}

.input-error {
  @apply input border-red-300 focus:ring-red-500;
}
```

### ナビゲーション
```css
.nav-item {
  @apply px-3 py-2 text-gray-700 hover:text-blue-600 hover:bg-blue-50 rounded-lg transition-colors duration-200;
}

.nav-item-active {
  @apply px-3 py-2 text-blue-600 bg-blue-50 rounded-lg;
}
```

## 6. レイアウト

### グリッドシステム
- **コンテナ**: `max-w-7xl mx-auto px-4 sm:px-6 lg:px-8`
- **カラム**: `grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6`
- **フレックス**: `flex flex-col sm:flex-row gap-4`

### レスポンシブデザイン
- **モバイルファースト**: 最小320pxから開始
- **ブレークポイント**: 
  - `sm`: 640px
  - `md`: 768px
  - `lg`: 1024px
  - `xl`: 1280px
  - `2xl`: 1536px

## 7. アニメーション

### トランジション
```css
/* 基本トランジション */
.transition-base {
  @apply transition-all duration-200 ease-in-out;
}

/* ホバーエフェクト */
.hover-lift {
  @apply transition-transform duration-200 hover:-translate-y-1;
}

/* フェードイン */
.fade-in {
  @apply animate-fade-in;
}
```

### カスタムアニメーション
```css
@keyframes fade-in {
  from { opacity: 0; transform: translateY(10px); }
  to { opacity: 1; transform: translateY(0); }
}

.animate-fade-in {
  animation: fade-in 0.3s ease-out;
}
```

## 8. アクセシビリティ

### フォーカス状態
```css
.focus-ring {
  @apply focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2;
}
```

### コントラスト比
- **テキスト**: 最低4.5:1
- **大きなテキスト**: 最低3:1
- **UI要素**: 最低3:1

## 9. ダークモード対応

### カラーテーマ
```css
/* ライトモード */
:root {
  --bg-primary: #ffffff;
  --bg-secondary: #f2f2f7;
  --text-primary: #1d1d1f;
  --text-secondary: #86868b;
}

/* ダークモード */
@media (prefers-color-scheme: dark) {
  :root {
    --bg-primary: #000000;
    --bg-secondary: #1c1c1e;
    --text-primary: #ffffff;
    --text-secondary: #8e8e93;
  }
}
```

## 10. 実装ガイドライン

### Tailwind CSSクラス使用例
```html
<!-- カードコンポーネント -->
<div class="bg-white rounded-lg shadow-sm border border-gray-200 p-4 hover:shadow-md transition-shadow duration-200">
  <h3 class="text-xl font-semibold text-gray-900 mb-2">タイトル</h3>
  <p class="text-gray-600 text-sm">説明文</p>
  <button class="mt-4 bg-blue-500 hover:bg-blue-600 text-white font-medium px-4 py-2 rounded-lg transition-colors duration-200">
    アクション
  </button>
</div>
```

### カスタムCSS使用例
```css
/* Tailwindで実装できない複雑なアニメーション */
@keyframes slide-in-right {
  from {
    transform: translateX(100%);
    opacity: 0;
  }
  to {
    transform: translateX(0);
    opacity: 1;
  }
}

.slide-in-right {
  animation: slide-in-right 0.3s ease-out;
}
```

## 11. 品質チェックリスト

- [ ] カラーパレットが一貫している
- [ ] タイポグラフィが階層的に整理されている
- [ ] スペーシングが統一されている
- [ ] レスポンシブデザインが適切に実装されている
- [ ] アクセシビリティガイドラインに準拠している
- [ ] ダークモード対応が完了している
- [ ] アニメーションが自然で滑らかである
- [ ] パフォーマンスが最適化されている