
# API仕様書
対象：todosテーブル
| 機能ID   | API名                | 説明                                                       |
| -------- | -------------------- | ---------------------------------------------------------- |
| TODO-001 | ToDo一覧全件取得     | ToDoテーブルに存在するデータを全件取得します。             |
| TODO-002 | 未完了ToDoの取得     | statusが"未完了"のToDoを取得します。                       |
| TODO-003 | 完了済みToDoの取得   | statusが"完了"のToDoを取得します。                         |
| TODO-004 | 新規ToDoの作成       | todosテーブルに新規データを一件登録します。                |
| TODO-005 | ToDoステータスの変更 | ToDoの完了・未完了を切り替えます。                         |
| TODO-006 | ToDoの更新           | ステータス以外の要素を変更します。主にタイトルが対象です。 |
| TODO-007 | ToDo削除             | ToDoデータを物理削除します。                               |

### 1. タスク一覧取得
```
GET /api/todos
Response: List<Todo>
```

### 2. 未完了タスク取得
```
GET /api/todos/incomplete
Response: List<Todo>
```

### 3. 完了済みタスク取得
```
GET /api/todos/complete
Response: List<Todo>
```

### 4. 新規タスク作成
```
POST /api/todos
Request: {"title": "タスクタイトル"}
Response: Todo
```

### 5. タスクステータス更新
```
PATCH /api/todos/{id}/status
Request: boolean (true: 完了, false: 未完了)
Response: 200 OK
```

### 6. タスク更新
```
PUT /api/todos/{id}
Request: {"title": "新しいタイトル"}
Response: 200 OK
```

### 7. タスク削除
```
DELETE /api/todos/{id}
Response: 200 OK
```