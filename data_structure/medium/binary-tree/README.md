# Binary tree


---Асуулт---"english" :
For the purposes of this challenge, we define a binary tree to be a binary search tree with the following ordering requirements:

The  value of every node in a node's left subtree is less than the data value of that node.
The  value of every node in a node's right subtree is greater than the data value of that node.
Given the root node of a binary tree, can you determine if it's also a binary search tree?

Complete the function in your editor below, which has  parameter: a pointer to the root of a binary tree. It must return a boolean denoting whether or not the binary tree is a binary search tree. You may have to write one or more helper functions to complete this challenge.

Input Format

You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass its root node to your function as an argument.

Constraints

Output Format

You are not responsible for printing any output to stdout. Your function must return true if the tree is a binary search tree; otherwise, it must return false. Hidden code stubs will print this result as a Yes or No answer on a new line.

Sample Input

tree

Sample Output

No

---Асуулт---"Монголоор" :
Сорилын зорилгоор бид хоёртын модыг дараах эрэмбэлэлтийн шаардлагатай хоёртын хайлтын мод (binary search tree) гэж тодорхойлно:

Аль ч зангилааны зүүн дэд модонд байгаа бүх зангилаануудын утга тухайн зангилааны утгаас бага байх ёстой.

Харин баруун дэд модонд байгаа бүх зангилаануудын утга тухайн зангилааны утгаас их байх ёстой.

Чи хоёртын модын үндсэн зангилааг (root) өгөгдсөн гэж үзвэл, тухайн мод нь хоёртын хайлтын мод мөн эсэхийг тодорхойлж чадах уу?

Доорх функцийн биеийг гүйцээ. Энэ функц 1 параметр авна: хоёртын модны үндсэн зангилаа руу заах заагч. Энэ нь тухайн мод хоёртын хайлтын мод мөн эсэхийг илэрхийлэх boolean (үнэн/худал) утга буцаах ёстой.

Энэ сорилын турш функцэд helper функц бичих шаардлагатай байж болох юм.

Оролтын формат:
Чи stdin-оос ямар ч оролт унших шаардлагагүй. Нууц код нь хоёртын модыг угсарч, үндсэн зангилааг функц руу дамжуулна.

Хязгаарлалт:
(Тодорхой хязгаарлалт өгөгдөөгүй байна, гэхдээ ямар нэг онцгой нөхцөл байж болно.)

Гаралтын формат:
Чи ямар ч гаралт хэвлэх шаардлагагүй. Таны функц true (үнэн) утга буцаавал, нууц код нь "Yes", харин false (худал) бол "No" гэж шугам дээр хэвлэнэ.

Жишээ оролт:
tree 
Жишээ гаралт:
No
---Код---"Python3"
""" Node is defined as
class node:
  def __init__(self, data):
      self.data = data
      self.left = None
      self.right = None
"""
def check_binary_search_tree_(root):
    def is_valid_bst(node, min_val, max_val):
        if node is None:
            return True
        if not (min_val < node.data < max_val):
            return False
        return (is_valid_bst(node.left, min_val, node.data) and
                is_valid_bst(node.right, node.data, max_val))

    return is_valid_bst(root, float('-inf'), float('inf'))

---Тайлбар--- 
Програм эхэндээ check_binary_search_tree_ нэртэй үндсэн функцтэй. Энэ функц нь модны үндсэн root нүдийг авч, туслах функц болох is_valid_bst-ийг дуудаж шалгалт хийдэг.

is_valid_bst туслах функцийн гол үүрэг:
Хэрэв тухайн нүд хоосон байвал (мөчир байхгүй бол), энэ нь BST-д саад болохгүй тул True гэж үзнэ.

Харин тухайн нүдний утга нь тодорхой заасан доод болон дээд хязгаарын хооронд байгаа эсэхийг шалгана. Хэрэв зөрчвөл буруу гэж үзээд False буцаана.

Хэрэв зөв бол тухайн нүдний зүүн хүүхдийн модыг дахин доод хязгаар болон энэ нүдний утга хоёрын хооронд байгааг шалгана.

Мөн баруун хүүхдийн модыг энэ нүдний утга болон дээд хязгаар хоёрын хооронд шалгана.

Ийнхүү бүх модыг дотор нь гүнзгий орж шалгаснаар BST-ийн нөхцөл зөрчигдөж байгаа эсэхийг тодорхойлдог.

