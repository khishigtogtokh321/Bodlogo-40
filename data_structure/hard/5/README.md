# merging

---Асуулт---"english" :
People connect with each other in a social network. A connection between Person  and Person  is represented as . When two persons belonging to different communities connect, the net effect is the merge the communities which  and  belong to.

At the beginning, there are  people representing  communities. Suppose person  and  connected and later  and  connected, then ,, and  will belong to the same community.

There are two types of queries:

 communities containing persons  and  are merged if they belong to different communities.

 print the size of the community to which person  belongs.

Input Format

The first line of input contains 2 space-separated integers  and , the number of people and the number of queries.
The next  lines will contain the queries.

Constraints



Output Format

The output of the queries.

Sample Input

STDIN Function ----- -------- 3 6 n = 3, q = 6 Q 1 print the size of the community containing person 1 M 1 2 merge the communities containing persons 1 and 2 ... Q 2 M 2 3 Q 3 Q 2

Sample Output

1
2
3
3
Explanation

Initial size of each of the community is .

---Асуулт---"Монголоор" :
Хүмүүс нийгмийн сүлжээнд хоорондоо холбогддог. Хүн a болон хүн b хоёрын хоорондын холбоог (a, b) гэж тэмдэглэнэ.
Хэрвээ хоёр хүн өөр өөр нийгэмлэгт харьяалагддаг бөгөөд тэд холбогдвол, тухайн хоёрын харьяалагдаж байсан нийгэмлэгүүд нэгдэх болно.

Эхэндээ n хүн байна гэж үзвэл, бүгд тус тусдаа n ширхэг нийгэмлэгт харьяалагдана.
Хэрвээ хүн 1 ба 2 холбогдож, дараа нь хүн 2 ба 3 холбогдвол, 1, 2, 3 бүгд нэг нийгэмлэгт харьяалагдах болно.

Хоёр төрлийн асуулт байна:

M a b — хэрвээ хүн a ба хүн b өөр өөр нийгэмлэгт харьяалагдаж байвал тэдний нийгэмлэгүүдийг нэгтгэнэ.

Q a — хүн a харьяалагдаж буй нийгэмлэгийн хэмжээг хэвлэнэ.

Оролтын формат:

Эхний мөрөнд 2 бүхэл тоо өгөгдөнө: n (хүмүүсийн тоо) ба q (асуултын тоо).
Дараагийн q мөр тус бүрт нэг асуулт байна.

Гаралтын формат:

"Асуулт бүрийн хариуг" хэвлэнэ.

Жишээ оролт:

3 6  
Q 1  
M 1 2  
Q 2  
M 2 3  
Q 3  
Q 2
Жишээ гаралт:

1  
2  
3  
3
---Код---" "
def union_join(member1, member2):
    if people_community_dict[member1] > people_community_dict[member2]:
        people_community_dict[member2] += people_community_dict[member1]
        people_community_dict[member1] = member2
    else:
        people_community_dict[member1] += people_community_dict[member2]
        people_community_dict[member2] = member1


def union_find(member):
    memberList = []
    # only when member is parent node id it will break it
    while people_community_dict[member] > 0:
        # looping to find the big parent (As parent )
        memberList.append(member)
        member = people_community_dict[member]
    # redirect all the members when loop through it to the parent
    for m in memberList:
        people_community_dict[m] = member
    return member


if __name__ == '__main__':
    num_of_people, num_of_query = map(int, input().split())
    # use -1 as init, only community root having -num and the abs(num) is the size of community
    people_community_dict = {i: -1 for i in range(1, num_of_people + 1)}

    for _ in range(num_of_query):
        cur_query = input().split()
        if cur_query[0] == "Q":
            member_id = int(cur_query[1])
            community_root = union_find(member_id)
            print(abs(people_community_dict[community_root]))
        else:
            member_id1, member_id2 = int(cur_query[1]), int(cur_query[2])
            root_m1, root_m2 = union_find(member_id1), union_find(member_id2)
            if root_m1 != root_m2:
                union_join(root_m1, root_m2)
---Тайлбар--- 
![image](https://github.com/user-attachments/assets/73a6a052-3032-4e12-90db-f1ca89a18f20)
