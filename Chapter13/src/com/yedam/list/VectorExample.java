package com.yedam.list;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		
		List<Board> list = new Vector<>();
		
//		Board board = new Board("제목1", "내용1", "글쓴이1");
//		list.add(board);
		list.add(new Board("제목1", "내용1", "글쓴이1"));
		list.add(new Board("제목2", "내용2", "글쓴이2"));
		list.add(new Board("제목3", "내용3", "글쓴이3"));
		list.add(new Board("제목4", "내용4", "글쓴이4"));		
		list.add(new Board("제목5", "내용5", "글쓴이5"));
		
		for(int i=0; i<list.size(); i++) {
			//첫번째 방법
			//향상된 for문 방식
			//Board board2 = list.get(i);
			//System.out.println(board2.subject + "\t" + board2.content + "\t" + board2.writer);
			//두번째 방법
			System.out.println(list.get(i).subject + "\t" + list.get(i).content + "\t" + list.get(i).writer);
		}
		
		list.remove(2);
		
		for(int i =0; i< list.size(); i++) {
			Board board2 = list.get(i);
			System.out.println(board2.subject + "\t" + board2.content + "\t" + board2.writer);
		}
		
		
		
		
		
		
	}
}
