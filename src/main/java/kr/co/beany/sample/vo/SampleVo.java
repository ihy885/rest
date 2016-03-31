package kr.co.beany.sample.vo;
 
public class SampleVo {
    private Integer sampleNo;
    private String title;
    private String description;
 
 
    
	public Integer getSampleNo() {
        return sampleNo;
    }
    public void setSampleNo(Integer sampleNo) {
        this.sampleNo = sampleNo;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
/*    
    public SampleVo(int sampleNo, String title, String description){
        this.sampleNo = sampleNo;
        this.title = title;
        this.description = description;
   }
    
    */
    
/*    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }*/
/* 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SampleVo other = (SampleVo) obj;
        if (sampleNo != other.sampleNo)
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "SampleVo [sampleNo=" + sampleNo + ", title=" + title + ", description=" + description
                + "]";
    }
 
    */
    
    
    
}