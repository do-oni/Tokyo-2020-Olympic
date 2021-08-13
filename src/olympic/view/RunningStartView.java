package olympic.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import olympic.controller.OlympicController;

public class RunningStartView {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("***** 2020 ���� �ø��� �����? *****");
		System.out.println("***** ������ : 2021.07.23 *****");
		System.out.println("***** �󸷽� : 2021.08.08 *****\n");
		System.out.println("~~~~~ ��� ��� ~~~~~");
		System.out.println(" 1 : ��� �ø��� ����" 
					   + "\n 2 : �ø��� ���� ���� ���" 
					   + "\n 3 : Ư�� ���� �� �޴� ��" 
					   + "\n 4 : Ư�� ���� ����"		
					   + "\n 5 : Ư�� ���� ����" 
					   + "\n 6 : Ư�� ���� ��ȣ�� ������ ����" 
					   + "\n 7 : �޴� ���ھ�� ��ŷ �˻� " 
					   + "\n 8 : �˻� ���� ���� ���� ���"
					   + "\n 9 : �˻� �׸�");
		
		boolean sessionEnd = false;
		
		while (!sessionEnd) {
			
			try {
				System.out.println("�޴� ��ȣ�� �Է����ּ���");
				
				int num = sc.nextInt();
				
				if(num == 1) {
					System.out.println("***��� �ø��� ���� ***");
					OlympicController.getAllOlympic();
				} else if(num == 2) {
					System.out.println("\n***��� �ø��� ���� ����***");
					OlympicController.getCountries();
				} else if(num == 3) {
					sc.nextLine();
					System.out.println("\n***Ư�� ���� ��� �޴� ��***");
					System.out.println("\n***������ �Է��ϼ���***");
					String country = sc.nextLine();
					OlympicController.getMedalCnt(country);
				} else if(num == 4) {
					sc.nextLine();
					System.out.println("\n***Ư�� ���� ����***");
					System.out.println("\n***������ �Է��ϼ���***");
					String country = sc.nextLine();
					System.out.println("\n***������ �Է��ϼ��� ***");
					String sportname = sc.nextLine();
					OlympicController.getSport(country, sportname);
				} else if(num == 5) {
					sc.nextLine();
					System.out.println("\n***Ư�� ���� ����***");
					System.out.println("\n***������ �Է��ϼ���***");
					String country = sc.nextLine();
					System.out.println("\n***������ �Է��ϼ��� ***");
					String name = sc.nextLine();
					OlympicController.getPlayer(country, name);
				} else if(num == 6) {
					sc.nextLine();
					System.out.println("\n***Ư�� ���� ��ȣ�� ������ ����***");
					System.out.println("\n***������ȣ�� �Է��ϼ���***");
					int playernum = sc.nextInt();
					sc.nextLine();
					System.out.println("\n***�̸��� �������ּ��� ***");
					String name = sc.nextLine();
					OlympicController.updatePlayer(name, playernum);
					System.out.println("\n***������ ���� �̸�***");
					OlympicController.getOnePlayer(name);
				} else if(num == 7) {
					System.out.println("\n***�޴� ���ھ�� ��ŷ �˻�***");
					OlympicController.getMedalScore();
				} else if(num == 8) {
					System.out.println("\n***���� ���� �˻��� �������***");
					OlympicController.searchLog();
				}  else if(num == 9) {
					sc.close();
					System.out.println("\n***�˻� ����***");
					sessionEnd = true;
				}else {
					System.out.println("�ٽ� �Է��� �ּ���");
				}
			} catch(InputMismatchException e) {
				System.out.println("���ڰ� �ƴ� ���� �Է��߽��ϴ�.");
				sc.next();
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("");
				sc.next();
			}
		}
	}
}