package game_project;

import java.util.ArrayList;
import java.util.Random;

public class Game {
	private ArrayList<Snail> snails;
	private int distance;
	private int size;
	private int current_rank;
	
	Random random = new Random();
	
	// 게임 디폴트 설정 (생성자) [거리 : 100, 달팽이 수 : 3]
	public Game() {
		this.size = 3;
		this.distance = 100;
		this.current_rank = 1;
		snails = new ArrayList<Snail>(size);
		
		for (int i = 0; i < size; i++) {
			addSnail(new Snail());
		}
	}
	
	// 달팽이 추가
	public void addSnail(Snail snail) {
		snails.add(snail);
	}
	
	// 모두 도착 했는가?
	public boolean all_is_arrived() {
		for (int i = 0; i < size; i++) {
			Snail snail = snails.get(i);
			if (snail.get_is_arrived() == false) {
				return false;
			}
		}
		return true;
	}
	
	// 현재 달팽이 위치 출력
	public void print_current_snail_state() {
		for (int i = 0; i < size; i++) {
			Snail snail = snails.get(i);
			System.out.print("snail" + (i+1) + " : ");
			if (snail.get_is_arrived() == true) {
				System.out.println("Arrived!");
			}
			else {
				System.out.println(snail.getCurrent_location());
			}
		}
		System.out.println("------------------------------------------------");
	}
	
	// 달팽이들 움직이기
	public void move_snails() {
		for (int i = 0; i < size; i++) {
			Snail snail = snails.get(i);
			if (snail.get_is_arrived() == false) {
				snail.move_foward(random.nextInt(10));
				if (snail.getCurrent_location() >= distance) {
					snail.set_is_arrived();
				}
			}
		}
	}
	
	// 랭킹 매기기
	public void rank_snails() {
		boolean flag = false;
		for (int i = 0; i < size; i++) {
			Snail snail = snails.get(i);
			if (snail.get_is_arrived() == true && snail.get_is_ranked() == false) {
				snail.setRank(current_rank);
				snail.set_is_ranked();
				flag = true;
			}
		}

		if (flag == true) {
			current_rank++;
		}
	}
	
	// 랭킹 출력
	public void print_ranking() {
		for (int i = 0; i < size; i++) {
			Snail snail = snails.get(i);
			System.out.println("snail" + (i+1) + " Ranking : " + snail.getRank());
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		
		while (!game.all_is_arrived()) {
			game.move_snails();
			game.print_current_snail_state();
			game.rank_snails();
		}
		
		game.print_ranking();
	}
}
