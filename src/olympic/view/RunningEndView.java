package olympic.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import olympic.exception.NotExistException;
import olympic.model.MedalDAO;
import olympic.model.OlympicService;
import olympic.model.dto.MedalDTO;
import olympic.model.dto.OlympicDTO;
import olympic.model.dto.PlayerDTO;
import olympic.model.dto.SportDTO;

public class RunningEndView {
	
	static OlympicService service = OlympicService.getInstance();

	public static void olympicListView(ArrayList allOlympic) {
		if (allOlympic != null) {
			int length = allOlympic.size();

			if (length != 0) {
				
				for (int index = 0; index < length; index++) {
					System.out.println("�˻����� " + (index + 1) + " - " + allOlympic.get(index));
				}
			} else {
				System.out.println("��û�Ͻ� �ø��� ������ �������� �ʽ��ϴ�.");
			}
		} else {
			System.out.println("��û�Ͻ� �ø��� ������ �������� �ʽ��ϴ�.");
		}
	}

	// Ư�� ���� �޴� �� ���
	public static void olympicView(MedalDTO medal) {
		System.out.println(medal);
	}

	// Ư�� ���� �˻�
	public static void olympicView(SportDTO sport) {
		if (sport == null) {
			System.out.println("�˻��� ������ �����ϴ�.");
		} else {
			System.out.println(sport);
		}
	}

	// Ư�� ���� �˻�
	public static void olympicView(PlayerDTO player) {
		System.out.println(player);
	}

	//��� DTO
	public static void allView(Object data) {
		if (data != null) {
			System.out.println(data);
		} else {
			System.out.println("��û�Ͻ� id�� �ش��ϴ� ������ �����ϴ�.");
		}
	}

	// update ����, ���н� �޼��� ��� -
	public static void updateView(boolean result, String name, int playerNum) {
		if (result) {
			System.out.println("��û�Ͻ� " + name + playerNum + " ���� �Ϸ�");
		} else {
			System.out.println("��û�Ͻ� " + name + " ���� ����, �ٸ� �̸����� �˻����ּ���.");
		}
	}

	// ���� ��Ȳ ���
	public static void showError(String message) {
		System.out.println(message);
	}

	public static void countryViewHS(HashSet<String> allCountryHS) {
		if (allCountryHS != null) {
			
			int length = allCountryHS.size();

			if (length != 0) {
				Iterator iter = allCountryHS.iterator();
				int i = 0;
				while (iter.hasNext()) {
					System.out.println("�˻����� " + (i + 1) + " - " + iter.next());
					i++;
				}
			} else {
				System.out.println("��û�Ͻ� ���� ������ �����ϴ�.");
			}
		} else {
			System.out.println("��û�Ͻ� ���� ������ �����ϴ�.");
		}
	}

	public static void olympicView(ArrayList<String> totalMedal) {
		System.out.println("�˻��Ͻ� ���� " + "'" + totalMedal.get(0) + "'" + "�� �޴� ȹ�� ��Ȳ�� �Ʒ��� �����ϴ�.\n" 
								  + "�ݸ޴� : " + totalMedal.get(1) + "��\n" 
								  + "���޴� : " + totalMedal.get(2) + "��\n" 
								  + "���޴� : " + totalMedal.get(3)+ "��\n" 
				  + "���� �ش� ������ �ø��� ������ " + totalMedal.get(4) + "���Դϴ�.");
	}

	public static void medalRankView(HashMap<Integer, String[]> medalScore) {
		if (medalScore != null) {
			
			for (Entry<Integer, String[]> entrySet : medalScore.entrySet()) {
				System.out.println(entrySet.getKey() + " : ����  :" + entrySet.getValue()[0] + ", ���� : "
						+ entrySet.getValue()[1] + ", ���ھ� : " + entrySet.getValue()[2]);
			}
		} else {
			System.out.println("��û�Ͻ� �޴� ��ũ ������ �����ϴ�.");
		}
	}

	public static OlympicDTO getOlympic(int olympicId) throws SQLException, NotExistException {
		
		OlympicDTO olympic = service.getOlympic(olympicId);
		
		if (olympic == null) {
			throw new NotExistException("�˻��Ͻ� �ø��� ������ �����ϴ�.");
		}
		return olympic;
	}
}