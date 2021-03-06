/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Kingston
 */
public class Document implements Comparable <Document>
{
    private int id;
    private String content;
    private double score;

    public Document(int id, String content, double score)
    {
        this.id = id;
        this.content = content;
        this.score = score;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }


    @Override
    public int compareTo(Document that) {
        return Double.valueOf(this.score).compareTo(that.score);
    }
}
