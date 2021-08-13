package olympic.controller;

import java.sql.SQLException;

import olympic.exception.NotExistException;
import olympic.model.OlympicService;
import olympic.model.PlayerDAO;
import olympic.view.RunningEndView;

public class OlympicController {
	
	static OlympicService service = OlympicService.getInstance();

	//1. ��� �ø��� ���� �˻�
	public static void getAllOlympic() {
		try {
		RunningEndView.olympicListView(service.getAllOlympic());
		}catch(SQLException s) {
			s.printStackTrace();
			RunningEndView.showError("��� �ø��� ���� �˻��� ���� �߻�");
		}
	}
	
	//2. �ø��� ���� ���� �˻�
	public static void getCountries() {
			try {
				RunningEndView.countryViewHS(service.getAllCountryHS());
			}catch(Exception e) {
				RunningEndView.showError("���� �˻��� ���� �߻�");
			}
	}

	//3. Ư�� ���� �޴� �� �˻�
	public static void getMedalCnt(String country) {
		try {
			RunningEndView.olympicView(service.getMedalCnt(country));
		}catch(SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("�����̸����� �޴� �� �˻� ���� �߻�");
		}catch(NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("������ Ȥ�� �������� �ٽ� �Է��� �ּ���.");
		}
	}
		
	//4. Ư�� ���� �˻�
	public static void getSport(String country, String sport) {
		try {
			RunningEndView.olympicView(service.getSport(country, sport));
		}catch(SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���� �̸����� �˻� ���� �߻�");
		}
	}

	//5. Ư�� ���� �˻�
	public static void getPlayer(String country, String name) {
			try {
				RunningEndView.olympicView(PlayerDAO.getPlayer(country, name));
			} catch (NotExistException e) {
				e.printStackTrace();
				RunningEndView.showError("���� �̸��� �ٽ� �Է��� �ּ���.");
			}catch(SQLException e) {
				e.printStackTrace();
				RunningEndView.showError("���� �̸����� �˻� ���� �߻�");
		}
	}
	
	//6. Ư�� �����̸����� ������ȣ ���� 
	public static void updatePlayer(String name, int playerNum) {
		try{
			boolean b = service.updatePlayer(name, playerNum);
			RunningEndView.updateView(b, name, playerNum);			
		}catch(SQLException e){
			e.printStackTrace();
			RunningEndView.showError("���� ��ȣ ���� ���� ��õ� �ϼ���.");
		}catch(NotExistException e){
			e.printStackTrace();
			RunningEndView.showError("���� �̸� �� Ȯ�� �ϼ���.");
		}
	}
	
	// ���� �̸� ���� ��� �˻�
	public static void getOnePlayer(String name) {
		try {
			RunningEndView.olympicView(service.getOnePlayer(name));
		}catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���� �̸����� �˻� ���� �߻�");
		}catch(NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("���� �̸� �� Ȯ�� �ϼ���.");
		}
	}
	
	
	//7. �޴� ���ھ�� ��ŷ �˻�
	public static void getMedalScore() {
		try {
			RunningEndView.medalRankView(service.getMedalScore());
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("���ھ� �˻� ����");
		}
	
	}

	//8. �˻� ���� ���� ���� ���
	public static void searchLog() {
		try {
			service.searchLog();
		} catch (NotExistException e) {
			e.printStackTrace();
			RunningEndView.showError("������ �������� �ʽ��ϴ�.");
		}
	}	
}