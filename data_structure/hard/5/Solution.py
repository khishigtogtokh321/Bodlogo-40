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
