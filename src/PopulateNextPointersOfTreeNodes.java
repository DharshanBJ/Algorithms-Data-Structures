
//Definition for binary tree with next pointer.
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulateNextPointersOfTreeNodes {

        public void connect(TreeLinkNode root) {
            // Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
            // if(root==null)return;
            // int count=0;
            // queue.add(root);
            // while(!queue.isEmpty()){
            //     count=queue.size();
            //     for(int i=0;i<count;i++){
            //         TreeLinkNode node=queue.poll();
            //         if(i==count-1){
            //             node.next=null;
            //         }else{
            //             node.next=queue.peek();
            //         }
            //         if(node.left!=null){
            //             queue.add(node.left);
            //         }
            //         if(node.right!=null){
            //             queue.add(node.right);
            //         }
            //     }
            // }

            TreeLinkNode node=root;
            TreeLinkNode levelHead=new TreeLinkNode(0); //dummy node

            while(node!=null){//go to the next level
                TreeLinkNode needle=levelHead;
                while(node !=null){ //iterate through the same level
                    if(node.left!=null){
                        needle.next=node.left; //needle keeps sewing together next level's children
                        needle=needle.next;
                    }

                    if(node.right !=null){
                        needle.next=node.right;
                        needle=needle.next;
                    }
                    node=node.next;//move node to next in same level,ends up null for rightmost node,signifying end of level
                }
                //current level ended in node being null
                node=levelHead.next; //take node from sentinel's next,which is next level's start
                levelHead.next=null;//should make it null as it will be pointing to the full upper level thread
                //if there are no more children left(last level),needle.next wont be updated,
                // hence levelHead.next which is same is needle.next will be null,signifying end of all levels

            }
        }
    }

