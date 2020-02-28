/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpeg;

import java.util.*;

/**
 *
 * @author Nagla Essam
 */
public class Compression {
    ArrayList<Integer> inputStream = new ArrayList<Integer>();
    ArrayList<Integer> zeros = new ArrayList<Integer>();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ArrayList<Integer> category = new ArrayList<Integer>();
    ArrayList<String> tags = new ArrayList<String>();
    ArrayList<String> fixedTags = new ArrayList<String>();
    ArrayList<String> huffmanTags = new ArrayList<String>();
    ArrayList<Integer> probs = new ArrayList<Integer>();
    
    ArrayList<String> binary = new ArrayList<String>();
    ArrayList<String> codes = new ArrayList<String>();
    ArrayList<String> compressedCode = new ArrayList<String>();
    
    String eob = "";
    
    public Compression (ArrayList<Integer> input){
        inputStream = input;
    }
    
    public void divide(){
        int counter = 0;
       
        for (int i=0 ; i<inputStream.size() ; i++){
            if (inputStream.get(i) == 0){
                counter++ ;
            }
            else {
                zeros.add(counter);
                numbers.add(inputStream.get(i));
                counter = 0; 
            }
        }
        if (counter != 0){
            eob = "EOB";
        }
    }
    
    public void getCategory(){
        String temp = "";
        for (int i=0 ; i<numbers.size() ; i++){
            if (numbers.get(i) <= 1 && numbers.get(i) >= -1){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(1);
            }
            else if (numbers.get(i) <= 3 && numbers.get(i) >= -3){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(2);
            }
            else if (numbers.get(i) <= 7 && numbers.get(i) >= -7){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(3);
            }
            else if (numbers.get(i) <= 15 && numbers.get(i) >= -15){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(4);
            }
            else if (numbers.get(i) <= 31 && numbers.get(i) >= -31){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(5);
            }
            else if (numbers.get(i) <= 63 && numbers.get(i) >= -63){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(6);
            }
            else if (numbers.get(i) <= 127 && numbers.get(i) >= -127){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(7);
            }
            else if (numbers.get(i) <= 255 && numbers.get(i) >= -255){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(8);
            }
            else if (numbers.get(i) <= 511 && numbers.get(i) >= -511){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(9);
            }
            else if (numbers.get(i) <= 1023 && numbers.get(i) >= -1023){
                if (numbers.get(i) > 0){
                    binary.add(Integer.toBinaryString(numbers.get(i)));
                }
                else {
                    temp = Integer.toBinaryString(Math.abs(numbers.get(i)));
                    StringBuilder myTemp = new StringBuilder(temp);
                    for (int b=0 ; b<temp.length() ; b++){
                        if (temp.charAt(b) == '0'){
                            myTemp.setCharAt(b, '1');
                        }
                        else{
                            myTemp.setCharAt(b, '0');
                        }
                    }
                    binary.add(myTemp.toString());
                }
                category.add(10);
            }
        }
    }
    
    public void fillTags(){
        for (int i=0 ; i<category.size() ; i++){
            tags.add(zeros.get(i) + "/" + category.get(i));
            fixedTags.add(zeros.get(i) + "/" + category.get(i));
        }
    }
    
    public void huffmanTable(){
        int probability = 1;
        for (int i=0 ; i<tags.size() ; i++){
            if (tags.get(i).equals(".")){
                continue;
            }
            for (int j=i+1 ; j<tags.size() ; j++){
                if (tags.get(i).equals(tags.get(j))){
                    probability++ ;
                    tags.remove(j);
                    tags.add(j , ".");
                }
            }
            huffmanTags.add(tags.get(i));
            probs.add(probability);
            probability = 1;
        }
        huffmanTags.add(eob);
        probs.add(probability);
        
        Huffman hf = new Huffman(huffmanTags , probs);
        hf.findCodes();
        codes = hf.getCodes();
        huffmanTags = hf.getTags();
    }
    
    public ArrayList<String> compress(){
        divide();
        getCategory();
        fillTags();
        huffmanTable();
        for (int i=0 ; i<fixedTags.size() ; i++){
            for (int j=0 ; j<huffmanTags.size() ; j++){
                if (fixedTags.get(i).equals(huffmanTags.get(j))){
                    compressedCode.add(codes.get(j) + ":" + binary.get(i));
                    break;
                }
            }
        }
        int index = huffmanTags.indexOf(eob);
        compressedCode.add(codes.get(index));
        
        //print();
        return compressedCode;
    }
    public void print(){
        
        System.out.println("++ " + zeros);
        System.out.println("-- " + numbers);
        System.out.println("1- " + tags);
        System.out.println("2- " + huffmanTags);
        System.out.println("3- " + probs);
        System.out.println("4- " + codes);
        System.out.println("5- " + binary);
        System.out.println("6- " + category);
        System.out.println("7- " + compressedCode);
    }
    
}
