package com.examination.util;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;
/**
 * 为了产生随机的题目而写的类
 * 根据传递的开始值和结束值，以及所生成题目的数量来生成一组随机数，即题号
 * 然后根据题号，到数据库中找题目，已实现随机出题的效果，这里还有一个默认序号，
 * 以应对用户不输入值或者输入的值不符合要求的情况
 * @author 
 *
 */
public class RandomNum {
	public static int[] randomNum(int stater,int end,int length){
		
		int[] deafl = {5, 7, 14, 13, 26, 10, 2, 23, 24, 15, 6, 1, 3, 30, 11, 25, 4, 29, 19, 22, 27, 8, 21, 9, 18, 20, 17, 28, 16, 12};
		int[] randomunms = new int[length];
		if(length>(end-stater)){
			return deafl;
		}
		for(int i=0;i<length;i++){
			int random = RandomUtils.nextInt(stater, end);
			if(isHave(random,randomunms)){
				randomunms[i] = random;
			}else{
				i--;
			}
			
		}
		return randomunms;
	}
	
	public static boolean isHave(int random,int[] arrays){
		for(int i=0;i<arrays.length;i++){
			if(arrays[i]==random){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arrays = randomNum(1,30,30);
		System.out.println(Arrays.toString(arrays));
		
	}
}
