package pepcoding_interviewprep;

import java.util.ArrayDeque;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class soln{
  
  
	
		public static int MaxPathSum(TreeNode node) {
        //right you code here.
        if(node==null)
        {
            return 0;
        }
        int sum=0;
        int leftsum=MaxPathSum(node.left);
        int rightsum=MaxPathSum(node.right);
        if(node.val>=0)
        {  if(node.left==null && (node.right!=null && node.right.val<0))
        {
            sum=Math.max(rightsum,node.val);
        }else if(node.right==null && (node.left!=null && node.left.val<0) )
        {
            sum=Math.max(leftsum,node.val);
        }else if(node.left==null && node.right==null)
        {
            sum=node.val;
        }else
            if( node.left.val<0 &&  node.right.val>=0 )
            {   
            sum=Math.max(leftsum,rightsum+node.val);
            }else if( node.left.val>=0 && node.right.val<0)
            {
                 sum=Math.max(rightsum,leftsum+node.val);
            }else if( node.left.val<0 && node.right.val<0)
            {
                 sum=Math.max(leftsum,Math.max(rightsum,node.val));
                
            }else
            {
                sum=leftsum+rightsum+node.val;
                
            }
        }else 
            {
            sum=Math.max(leftsum,rightsum);
        }
        return sum;
        
    }
	
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static Scanner scn = new Scanner(br);

	public static void main(String[] args) {
		solve();
	}

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data, TreeNode left, TreeNode right) {
			this.val = data;
			this.left = left;
			this.right = right;
		}

		public TreeNode(int data) {
			this.val = data;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();

			sb.append(left != null ? left.val : ".");
			sb.append(" -> " + val + " <- ");
			sb.append(right != null ? right.val : ".");
			sb.append("\n");

			if (left != null)
				sb.append(left);
			if (right != null)
				sb.append(right);

			return sb.toString();
		}
	}

	// constructor.=====================================================

public static TreeNode constructor_levelOderSerailize(Integer[] arr) {
		ArrayDeque<TreeNode> que = new ArrayDeque<>();
		TreeNode root = new TreeNode(arr[0]);
		que.addLast(root);
		int i = 1;
		while (!que.isEmpty() && i < arr.length) {
			TreeNode nn = que.removeFirst();

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.left = n;
				que.addLast(n);
			}
			i++;

			if (i < arr.length && arr[i] != null) {
				TreeNode n = new TreeNode(arr[i]);
				nn.right = n;
				que.addLast(n);
			}
			i++;
		}

		return root;
	}

		// generalUtil.============================================

	public static Integer[] inputSplitSpace(String str) {
		String[] sArr = str.split(" ");
		Integer[] arr = new Integer[sArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sArr[i].equals("null") ? null : Integer.parseInt(sArr[i]);
		}
		return arr;
	}

//================================================================================


	public static void solve() {
		Integer[] arr = inputSplitSpace(scn.nextLine());

		TreeNode root = constructor_levelOderSerailize(arr);
		// System.out.println(root.toString());

		System.out.println(MaxPathSum(root));

	}

}
