# SpringBoot-Hibernate
Spring Boot database access with Hibernate


**@Entitiy**// veritabanı nesnesini tanımlama
**@Table(name=” ”)** // veritabanı tablo adı (class adı ile aynı olacak)

**@Id**// ayırt edici
**@Column(name=”id”)** // sütün eşleştirme 

**@Transactional** // Transaction veri tabanı üzerinde yaptığımız birden çok işlemin bir bütün olarak veri tabanına işlenmesini, hata olduğunda bunların hepsinin geri alınmasını sağlar. Böylece veri tabanına aktarılan kayıtlarda herhangi bir tutarsızlığın önüne geçilmiş ve veri bütünlüğü sağlanmış olur. Biz @Transactional annotasyonunu kullandığımızda Spring Container da farklı bir şey yapmıyor aslında. O da bizim metodumuz işlenmeden önce bir transaction başlatıyor ve eğer method başarılı olursa, yani herhangi bir hata fırlatmaz ise transactionı commit ile sonlandırıyor veya hata durumunda geri alıyor.

**Entity** // Veritabanında bir kayıt gibi saklanan kalıcı nesnelerdir. Tipik olarak bir entity;ilişkisel veritabanındaki bir tabloyu gösterir. 

**EntityManager** // Nesneler üzerindeki kalıcılık (persistence) işlemlerini yöneten arayüzdür. Sorgular için bir fabrika gibi çalışır. Select,insert,update,delete gibi metotları bulunur.
JPA, çalışma zamanı kullanımı için API'yi kullanır EntityManager. EntityManagerVeritabanı ile uygulama oturumunu veya iletişim kutusunu temsil eder . EntityManagerHer istek veya her müşteri veritabanına erişmek için kendi kullanacaktır . EntityManager gerekli tüm kalıcılık işlemleri için bir API sağlar . Bunlar, aşağıdaki CRUD işlemlerini içerir:
persist (INSERT)
merge (UPDATE)
remove (DELETE)
find (SELECT)
Bu, EntityManager nesne yönelimli bir API'dir, dolayısıyla doğrudan veritabanı SQL veya DML işlemleriyle eşleşmez. Örneğin, bir nesneyi güncellemek için, nesneyi okumanız ve yöntemlerini kullanarak durumunu değiştirmeniz ve ardından commit işlemi çağırmanız yeterlidir . Hangi nesneleri değiştirdiğinizi anlar EntityManager ve veritabanına doğru güncellemeleri yapar, JPA'da açık bir güncelleme işlemi yoktur.
