USE [PT12]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Course](
	[id] [int] identity(1,1) NOT NULL,
	[name] [varchar](150) NOT NULL,
	[group] int not null
 CONSTRAINT [PK_Course] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Teacher](
	[id] [int] identity(1,1) NOT NULL,
	[name] [varchar](150) NOT NULL,
	[dob] [smalldatetime] NOT NULL,
	[address] [varchar](max) NOT NULL,
	[courseid] [int] NOT NULL foreign key references [dbo].[Course](id),
	[teachqual] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Teacher] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

INSERT [dbo].[Course] ([name],[group]) VALUES (N'English',1)
INSERT [dbo].[Course] ([name],[group]) VALUES (N'Japanese',1)
INSERT [dbo].[Course] ([name],[group]) VALUES (N'Chinese',1)
INSERT [dbo].[Course] ([name],[group]) VALUES (N'Korean',1)
INSERT [dbo].[Course] ([name],[group]) VALUES (N'Office',2)
INSERT [dbo].[Course] ([name],[group]) VALUES (N'Web design',2)
INSERT [dbo].[Course] ([name],[group]) VALUES (N'Java',2)

INSERT [dbo].[Teacher] ([name], [dob], [address],[courseid],[teachqual]) VALUES (N'Nguyen Van A', '01/05/2000','Ha Noi', 1,'Good')
INSERT [dbo].[Teacher] ([name], [dob], [address],[courseid],[teachqual]) VALUES (N'Nguyen Van B', '02/06/2000','Ha Noi', 3,'Very Good')
