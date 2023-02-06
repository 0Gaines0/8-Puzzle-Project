package edu.westga.cs3151.the8puzzle.model;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class PuzzleSolver {

	private static final int GOAL_TILES_SORTED = 8;

	public Deque<Board> bfsHelpAlogrithm(Board src) {
		Queue<Board> boardQ = new LinkedList<Board>();
		ArrayList<Board> vistedBoards = new ArrayList<Board>();
		vistedBoards.add(src);
		boardQ.add(src);
		while (!boardQ.isEmpty()) {
			Board currBoard = boardQ.poll();
			if (currBoard.getNumberSortedTiles() == src.getNumberSortedTiles() + 1) {
				Deque<Board> goalBoardPath = new LinkedList<Board>();
				while (currBoard != null) {
					goalBoardPath.add(currBoard);
					currBoard = currBoard.getParent();
				}
				return goalBoardPath;
			}
			for (Board bo : currBoard.neighborsBoards()) {
				if (!vistedBoards.contains(bo)) {
					vistedBoards.add(bo);
					bo.setParent(currBoard);
					boardQ.add(bo);
				}
			}
		}
		return null;
	}

	public Deque<Board> bfsSolveAlogrithm(Board src) {
		Queue<Board> boardQ = new LinkedList<Board>();
		ArrayList<Board> vistedBoards = new ArrayList<Board>();
		vistedBoards.add(src);
		boardQ.add(src);
		while (!boardQ.isEmpty()) {
			Board currBoard = boardQ.poll();
			if (currBoard.getNumberSortedTiles() == GOAL_TILES_SORTED) {
				Deque<Board> goalBoardPath = new LinkedList<Board>();
				while (currBoard != null) {
					goalBoardPath.add(currBoard);
					currBoard = currBoard.getParent();
				}
				return goalBoardPath;
			}
			for (Board bo : currBoard.neighborsBoards()) {
				if (!vistedBoards.contains(bo)) {
					vistedBoards.add(bo);
					bo.setParent(currBoard);
					boardQ.add(bo);
				}
			}
		}
		return null;
	}

	/**
	 * Find moves.
	 *
	 * @param boardQ the board Q
	 * @return the queue
	 */
	public Queue<Move> findMoves(Deque<Board> boardQ) {
		Queue<Move> moves = new LinkedList<>();
		Board currBoard = boardQ.removeLast();
		while (!(boardQ.isEmpty())) {
			Board nextBoard = boardQ.peekLast();
			Move newMove = new Move(nextBoard.getEmptyTilePosition(), currBoard.getEmptyTilePosition());
			moves.add(newMove);
			currBoard = nextBoard;
			boardQ.removeLast();

		}
		return moves;

	}
}
