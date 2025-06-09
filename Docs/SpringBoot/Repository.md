# Repository編

## Repositoryとは
Repositoryは、データアクセス層を担当するコンポーネントです。主な役割は以下の通りです：

- データベースとのやり取りを抽象化
- エンティティの永続化と取得
- データアクセスロジックのカプセル化

Spring Data JPAを使用することで、インターフェースを定義するだけで基本的なCRUD操作が自動的に実装されます。

## 使い方

### 基本的な実装例
```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 基本的なCRUD操作は自動的に実装される
    
    // カスタムクエリの例
    List<User> findByLastName(String lastName);
    
    // @Queryアノテーションを使用した例
    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);
}
```

### Repositoryの実例

```java
package com.example.spring_app.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByUserName(String lastName);
}

```

### Repositoryで実装される基本機能
Repositoryを作成するだけでいくつかの基本機能がコードを書かずに利用することが出来ます。

1. 基本的なCRUD操作
   - `save(T entity)`: エンティティの新規作成・更新
   - `findById(ID id)`: IDによる1件取得
   - `findAll()`: 全件取得
   - `delete(T entity)`: エンティティの削除
   - `count()`: レコード数の取得

2. ページネーション機能
   - `findAll(Pageable pageable)`: ページ単位での取得
   - `findAll(Sort sort)`: ソート機能付きの取得

3. メソッド名によるクエリ生成
   - `findBy[プロパティ名]`: プロパティによる検索
   - `findBy[プロパティ名]And[プロパティ名]`: AND条件での検索
   - `findBy[プロパティ名]Or[プロパティ名]`: OR条件での検索
   - `findBy[プロパティ名]OrderBy[プロパティ名]`: ソート付き検索

4. カスタムクエリ
   - `@Query`アノテーションによるJPQL/ネイティブSQL
   - `@Modifying`アノテーションによる更新クエリ

これらの機能は、インターフェースを定義するだけで自動的に実装され、すぐに使用することができます。


### 主要なアノテーション

1. `@Repository`
   - データアクセス層のコンポーネントであることを示す
   - Springのコンポーネントスキャンの対象となる
   - 例外をSpringのDataAccessExceptionに変換

2. `@Query`
   - カスタムクエリを定義する
   - JPQLまたはネイティブSQLを使用可能
   ```java
   @Query("SELECT u FROM User u WHERE u.age > :age")
   List<User> findUsersOlderThan(@Param("age") int age);
   ```

3. `@Modifying`
   - データを更新するクエリであることを示す
   - @Queryと組み合わせて使用
   ```java
   @Modifying
   @Query("UPDATE User u SET u.status = :status WHERE u.id = :id")
   int updateUserStatus(@Param("id") Long id, @Param("status") String status);
   ```

4. `@Param`
   - クエリパラメータに名前を付ける
   - @Queryアノテーションと組み合わせて使用

5. `@Transactional`
   - トランザクション管理を指定
   - デフォルトでは読み取り専用
   ```java
   @Transactional(readOnly = true)
   List<User> findAll();
   ```

## まとめ
- Repositoryはデータアクセス層の責務を担当
- Spring Data JPAにより、最小限のコードで実装可能
- カスタムクエリの実装が容易
- テストがしやすい設計
