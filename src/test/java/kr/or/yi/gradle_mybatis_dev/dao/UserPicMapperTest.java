package kr.or.yi.gradle_mybatis_dev.dao;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import kr.or.yi.gradle_mybatis_dev.AbstractTest;
import kr.or.yi.gradle_mybatis_dev.dto.UserPics;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserPicMapperTest extends AbstractTest {
	private static UserPicMapper picDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		picDao = new UserPicMapperImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		picDao = null;
	}

	@Test
	public void test01DeleteUserPics() throws FileNotFoundException, IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPics userPics = new UserPics();
		userPics.setId(1);
		
		int res = picDao.deleteUserPics(userPics);
		Assert.assertEquals(1, res);
		
		File pics = new File(System.getProperty("user.dir")+"\\pics\\"+"이다빈.jpg");
		if(pics.exists()) {
			pics.delete();
		}
		
	}

	@Test
	public void test02InsertUserPic() throws FileNotFoundException, IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPics userPics = new UserPics();
		userPics.setId(1);
		userPics.setName("이다빈");
		String bio = "모모랜드의 숨겨진 비주얼 보석으로 평가받는다.170cm의 큰 신장[12]과 군살없이 탄탄한 몸매, 길쭉한 비율로 어디에 있어도 시선을 잡아끄는 미모를 보유하고 있다.데뷔 전 서바이벌 모모랜드를 찾아서에서도 낸시와 함께 센터 후보로 평가받았고, 데뷔 곡 짠쿵쾅 에서 실제로 초반부 및 후렴 센터를 맡으면서 회사에서도 어느 정도 밀어보려는 제스처를 보이기도 했다.[13]"
				+ "'어마어마해'에서 한 소절 밖에 받지 못하고 후렴구 센터 역시 전혀 받지 못하는 등 사이드로 자꾸 밀렸다가, '꼼짝마' 에서 다시 후렴구 센터로 복귀한다."
				+ "2018년 1월 3일 컴백 곡 '뿜뿜'에서 비중이 다시 늘었다. 1절 일부와 브릿지를 모두 가져갔다.[14] 뿜뿜 브릿지 파트에서 추는 섹시 안무는 연우가 생각해낸 것이라고 한다. 이왕 섹시하게 가는거 진짜 제대로 한 번 가보자는 마인드로 창작했다고. 그리고 그 마인드는 제대로 통했다. 외국인들의 뮤비 리액션 영상을 보면 크게 두 번 환호하는데, 한 번은 데이지와 주이의 랩 부분, 나머지 한 번은 브릿지 파트에서 섹시댄스를 추는 연우 부분이다."
				+ "신곡 I'm so hot에서는 제대로 안무 센터로 밀어주었다. 후렴구 센터는 물론 시작 및 엔딩 센터 모두 담당했다. 확실히 본인의 비주얼 및 화제성을 소속사도 인정한 것으로 보인다."
				+ "전반적으로 곡 컨셉에 따라 사이드에 섰다가 센터로 밀어줬다가 편차가 큰 편이다. 일부 사람들은 연우를 '깜찍, 코믹한 현 모모랜드 컨셉 보다는 섹시, 청초 컨셉에 훨씬 더 잘 어울린다'는 평을 하기도 한다."
				+ "몸매로 주목받고 있는데, 표현력과 창의성도 한몫한다. 주로 넓은 골반과 길쭉한 몸매 비율 등이 성별을 가리지 않고 인기가 많은 비결로 꼽히며 안무 창의성과 표현력도 인정받고 있다.";
		userPics.setBio(bio);
		userPics.setPic(getPicFile());
		int result = picDao.insertUserPic(userPics);
		Assert.assertEquals(1, result);

	}

	private byte[] getPicFile() throws FileNotFoundException, IOException {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "\\images\\이다빈.jpg");
		try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
			pic = new byte[bis.available()];
			bis.read(pic);

			return pic;
		}
	}

	@Test
	public void test03SelectUserPics() throws FileNotFoundException, IOException {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		UserPics userPics = new UserPics();
		userPics.setId(1);

		UserPics searchPic = picDao.selectUserPics(userPics);
		Assert.assertNotNull(searchPic);
		if (searchPic.getPic() != null) {
			File file = getPicFile(searchPic);
			log.debug("file Path = " + file.getAbsolutePath());
		}
	}

	private File getPicFile(UserPics searchPic) throws FileNotFoundException, IOException {
		File pics = new File(System.getProperty("user.dir") + "\\pics\\");
		if (pics.exists() == false) {
			pics.mkdir();
		}

		File pic = new File(pics, searchPic.getName() + ".jpg");
		try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(pic))) {
			output.write(searchPic.getPic());
		}
		return pic;
	}

}
