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