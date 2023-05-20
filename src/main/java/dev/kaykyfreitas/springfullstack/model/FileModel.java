package dev.kaykyfreitas.springfullstack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_file")
public class FileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    private Long filesize;

    private String filetype;

    @Lob
    private byte[] content;

    public FileModel() {}

    public FileModel(String filename, Long filesize, String filetype, byte[] content) {
        this.filename = filename;
        this.filesize = filesize;
        this.filetype = filetype;
        this.content = content;
    }

    public FileModel(Long id, String filename, Long filesize, String filetype, byte[] content) {
        this.id = id;
        this.filename = filename;
        this.filesize = filesize;
        this.filetype = filetype;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FileModel{" +
                "id=" + id +
                ", filename='" + filename + '\'' +
                ", filesize=" + filesize +
                ", filetype='" + filetype + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
