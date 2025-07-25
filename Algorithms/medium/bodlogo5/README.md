# Queen's Attack II
Танд хатан болон хэд хэдэн саад байрлуулсан квадрат шатрын самбар өгөгдөнө. Хатан хэдэн нүд рүү довтолж чадахыг тодорхойл.
Хатан n × n хэмжээтэй шатрын самбар дээр байрласан байна. Самбарын мөрүүд нь доороос дээш чиглэлтэйгээр 1-ээс n хүртэл дугаарлагддаг. Баганууд нь зүүнээс баруун тийш чиглэлтэйгээр мөн 1-ээс n хүртэл дугаарлагддаг. Самбарын аль ч нүдийг (r, c) хосоор илэрхийлэх ба энэ нь тухайн нүдний мөр r, багана c-г илтгэнэ.
Хатан (r_q, c_q) байрлалд байрласан. Нэг удаагийн нүүдлээрээ хатан дараах найман чиглэлд байгаа дурын нүд рүү довтолж чадна: зүүн, баруун, дээш, доош, мөн дөрвөн диагональ чиглэл.
Доорх зурган дээр (4, 4) байрлалд байгаа хатан ямар нүднүүд рүү довтолж чадахыг ногоон дугуйгаар тэмдэглэсэн байна:

![1485426500-a4039ebb00-chess1](https://github.com/user-attachments/assets/65930abb-73c0-4cd8-be55-77c44608bd89)

Самбар дээр сааднууд байрлах ба эдгээр нь тухайн чиглэлд саадаас цааш байрлах нүднүүд рүү хатан довтлохоос сэргийлнэ. Жишээлбэл, дээрх зурган дээрх (3, 5) байрлалд байгаа саад нь хатанг дараах нүднүүд рүү довтлохоос сэргийлнэ: (3, 5), (2, 6), болон (1, 7).

![image](https://github.com/user-attachments/assets/b020861c-106b-43e5-b8ac-b8e7d3b2e35a)

Хатангийн байрлал болон самбар дээрх бүх саадны байршлууд өгөгдсөн нөхцөлд, хатан (r_q, c_q) байрлалаас хэдэн нүд рүү довтлох боломжтойг олж, хэвлэ.

Доорх queensAttack нэртэй функцийг гүйцээх шаардлагатай.

Функцийн тайлбар: 

  - int n, самбарын хэмжээ (n x n)
  - int k, саадны тоо
  - int r_q, int c_q, хатангийн мөр ба баганын дугаар
  - int obstacles[k][2] k ширхэг саадны байршил (мөр, багана)

Буцаах утга:
 - Хатангийн довтолж чадах нүдний тоо (int төрөлтэй).

Оролтын формат:
Эхний мөрөнд хоёр бүхэл тоо: n (самбарын хэмжээ), k (саадны тоо).

Дараагийн мөрөнд хатангийн байрлалын координат: r_q (мөр), c_q (багана).

Дараагийн k мөр бүрт нэг саадны байрлал өгөгдөнө: r[i] ба c[i].

Хязгаарлалт:
 0 < n ≤ 100,000
 0 ≤ k ≤ 100,000 

Нэг нүдэнд олон саад байж болно.

Хатан байрлаж буй нүдэнд хэзээ ч саад байхгүй.
Дэд даалгаврууд:
30% оноо авах нөхцөлд:

 0 < n ≤ 100 
 0 ≤ k ≤ 100

Нийт 55% оноо авах нөхцөлд:

 0 < n ≤ 1000
 0 ≤ k ≤ 10^5

 Оролт:
  40
  44

Гаралт: 9

Үр дүн: 
![Screenshot (359)](https://github.com/user-attachments/assets/4d944fcf-347f-4229-b9c2-de85a82ce19d)

Бодлогийн холбоос: https://www.hackerrank.com/challenges/queens-attack-2/problem




