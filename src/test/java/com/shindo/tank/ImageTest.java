package com.shindo.tank;


import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author: 杨耿
 * @Description:
 * @Date: Create in 2020/7/15
 * @Modified By:
 * @Modified Date:
 */
class ImageTest {

    @Test
    void test(){
        try {
            //绝对路径读取图片
            /*BufferedImage image = ImageIO.read(new File("D:/jetbrain/shindospaces/tank/src/main/resources/images/bulletD.gif"));
            assertNotNull(image);*/

            //相对路径读取图片
            BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            assertNotNull(image2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
